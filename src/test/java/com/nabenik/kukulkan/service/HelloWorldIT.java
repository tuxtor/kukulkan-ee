package com.nabenik.kukulkan.service;

import com.nabenik.kukulkan.util.TestUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ArquillianExtension.class)
public class HelloWorldIT {

    @Inject
    HelloService helloService;

    @Deployment
    public static WebArchive createDeployment() {

        // Create deploy file
        WebArchive war = TestUtil.createBasePersistenceWar()
                .addClass(HelloService.class);

        // Show the deploy structure
        System.out.println(war.toString(true));;
        return war;
    }

    @Test
    public void helloTest() {
        var resultadoEsperado = "Hello Victor";
        var resultadoObtenido = helloService.doHello("Victor");
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}
