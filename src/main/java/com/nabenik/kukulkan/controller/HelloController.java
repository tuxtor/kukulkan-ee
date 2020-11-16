package com.nabenik.kukulkan.controller;

import com.nabenik.kukulkan.service.HelloService;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * A simple JAX-RS endpoint useful for testing
 *
 * @author tuxtor
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    Logger logger;

    @Inject
    @ConfigProperty(name = "name", defaultValue = "mundo version 2.0")
    String name;

    @Inject
    HelloService helloService;

    @GET
    public String sayHello() {
        logger.info("User went to hello world!");
        return helloService.doHello(name);
    }
}
