package com.nabenik.kukulkan.service;

import javax.enterprise.inject.Default;

public class HelloService {

    public String doHello(String name){
        return "Hello ".concat(name);
    }
}
