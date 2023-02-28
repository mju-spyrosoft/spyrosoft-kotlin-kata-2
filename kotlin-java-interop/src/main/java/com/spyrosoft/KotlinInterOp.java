package com.spyrosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class KotlinInterOp {

    public static void main(String[] args) {
        SpringApplication.run(KotlinInterOp.class, args);
    }

    private final ServiceInJava serviceInJava;

    public KotlinInterOp(ServiceInJava serviceInJava) {
        this.serviceInJava = serviceInJava;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        serviceInJava.helloFromJava1();
        System.out.println("hello world, I have just started up");
    }
}
