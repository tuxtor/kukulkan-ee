# Kukulkan-EE

## Introduction

Kukulkan EE is an opinionated bootstrap project for JavaEE/JakartaEE 8.0 and Microprofile 3 family.

The principal motivator behind this is time. Despite being the foundation of Enterprise Java ecosystem, bootstrapping CDI projects is a time consuming and sometimes redundant task.

Hence Kukulkan EE was created with the following principles:

* Provide a bootstrap project for traditional .war deployments, fat jars, just enough application server and docker. Just point your IDE to the git repo and start your own fork.
* Allow type-safe and fast data repository generation with Deltaspike Data
* Allow CI/CD workflows with Arquillian and Maven
* Execute compatibility tests using GitHub Actions.

Kukulkan integrates the following dependencies:

* Java 11 - As language
* Maven - SCM/Task Runner
* SL4J - log abstraction (using JDK log by default)
* Payara 5 - runtime
* Jakarta EE 8 and MicroProfile 3.3 - APIs

This is a work in progress

## Why Kukulkan?

In the Mayan mithology [Kukulkan](https://en.wikipedia.org/wiki/Kukulkan) is one of the deities that created (hence bootstrapped) the universe.

Also as an internal joke, this project maintained/useful project for a [Guatemalan company](https://www.nabenik.com/) and people in Guatemala tend  to overuse Mayan terms.


## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)
