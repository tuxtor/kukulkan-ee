package com.nabenik.kukulkan.service;

import com.nabenik.kukulkan.util.TestUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
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
        Assert.assertEquals(resultadoEsperado, resultadoObtenido);
    }
}
