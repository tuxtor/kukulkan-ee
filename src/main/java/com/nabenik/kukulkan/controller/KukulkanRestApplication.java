package com.nabenik.kukulkan.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RS Base activator
 *
 * @author tuxtor
 */
@ApplicationPath("/rest")
@ApplicationScoped
public class KukulkanRestApplication extends Application {
}
