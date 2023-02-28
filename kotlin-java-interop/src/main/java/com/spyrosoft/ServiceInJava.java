package com.spyrosoft;

import org.springframework.stereotype.Service;

@Service
public class ServiceInJava {

    private final ServiceInKotlin serviceInKotlin;

    public ServiceInJava(ServiceInKotlin serviceInKotlin) {
        this.serviceInKotlin = serviceInKotlin;
    }

    public void helloFromJava1() {
        System.out.println("hello from java service");
        serviceInKotlin.justTryingKotlinOut();
    }

}
