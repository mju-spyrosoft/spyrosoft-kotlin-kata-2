package com.spyrosoft

import org.springframework.stereotype.Service

@Service
class ServiceInKotlin(val sericeInJava2: ServiceInJava2) {

    fun justTryingKotlinOut() {
        println("hello from kotlin")
        sericeInJava2.helloFromServiceJava2()
    }
}

