package com.nabenik.kukulkan.util;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;

public class TestUtil {


    /**
     * Create a global WebArchive that includes dummy persistence, deltaspike configuration and model classes. Aimed for
     * IT at repositories/controllers
     *
     * All pom.xml dependencies have been included
     *
     * @return WebArchive with persistence layer
     */
    public static WebArchive createBasePersistenceWar(){

        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importCompileAndRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        //Creating war and adding libraries
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackage("com.nabenik.kukulkan.model")
                .addPackage("com.nabenik.kukulkan.repository")
                .addPackage("com.nabenik.kukulkan.util")
                .addAsResource("META-INF/apache-deltaspike.properties", "META-INF/apache-deltaspike.properties")
                .addAsResource("META-INF/microprofile-config.properties", "META-INF/microprofile-config.properties")
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("test-beans-default.xml", "beans.xml")
                .addAsLibraries(files);

        //War exclussions (Mostly from util package)
        return war;
    }


}
