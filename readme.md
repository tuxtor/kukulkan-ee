# Kukulkan-EE

## Introduction

Kukulkan EE is an opinionated bootstrap project for JavaEE/JakartaEE 8.0 and Microprofile 4 family.

The principal motivator behind this is time. Despite being the foundation of Enterprise Java ecosystem, bootstrapping CDI projects is a time consuming and sometimes redundant task.

Hence Kukulkan EE was created with the following principles:

* Provide a bootstrap project for traditional .war deployments, fat jars, just enough application server and Docker. Just point your IDE to the git repo and start your own fork.
* Allow type-safe and fast data repository generation with Deltaspike Data
* Allow CI/CD workflows through Arquillian and Maven
* Execute compatibility tests using GitHub Actions.

Kukulkan integrates the following dependencies:

* Java 17 - As language
* Maven - SCM/Task Runner
* SL4J - log abstraction (using JDK log by default)
* Payara 5 - runtime
* Jakarta EE 8 and MicroProfile 4.1 - APIs
* JKube for basic Docker/K8S control using Maven

This is a work in progress.

## Why Kukulkan?

In the Mayan mithology [Kukulkan](https://en.wikipedia.org/wiki/Kukulkan) is one of the deities that created (hence bootstrapped) the universe.

Also as an internal joke, this project is a maintained/useful project for a [Guatemalan company](https://www.nabenik.com/) and people in Guatemala tend to overuse Mayan terms.

## Specification examples

By default, Kukulkan includes the creation of a JAX-RS application class to define the path for endpoints.

Also, a simple Hello world endpoint is created, have a look **HelloController** class.

More information on MicroProfile can be found [here](https://microprofile.io/)

## Usage 

This sample project has been created to achieve three basic tasks:

1. To produce a tested classic .war file, using only Maven 3.8.x and Java 17. The following command should achieve this task 

```bash
mvn clean verify
```

This will 1. Download all dependencies, 2. Execute Arquillian tests with JUnit file, 3. Produce a .war file in the target folder. Please also note that `verify` target is used for testing (Integration tests) via Failsafe plugin, otherwise only unit tests will be executed.

2. Control and pack the applications in Uber Jar mode, using [Payara Micro's Maven plugin](https://docs.payara.fish/community/docs/documentation/ecosystem/maven-plugin.html). For this please use the `payara-micro` profile.

For example, to execute the project directly from command line, just invoke the start target:

```bash
mvn package -Ppayara-micro payara-micro:start
```

To produce an uber jar, just invoke the bundle target:

```bash
mvn package -Ppayara-micro payara-micro:bundle
```

It will produce a file named `kukulkan-ee-microbundle.jar` in the target folder.

3. To produce a Docker container via [JKube](https://www.eclipse.org/jkube/). Please note that you have to produce the war file first, as example the following line will test the code, produce the war and also build a Docker image:

```bash
mvn verify k8s:build
```

By default, it will produce a Docker image named `nabenik/kukulkan-ee` which in turn could be personalized with JKube and/or changing project's group and artifact's name.

You'll also find two Dockerfiles at project's root, one plain old Dockerfile included for reference, and Dockerfile.jkube with support for Maven's variable interpolation, also used by JKube.

Please also note that you need Docker or Podman (with Docker compatibility) installed in your machine.


## Archetype

You could generate a project similar to this using [Kukulkan EE Archetype](https://tuxtor.github.io/kukulkan-ee-archetype/)
