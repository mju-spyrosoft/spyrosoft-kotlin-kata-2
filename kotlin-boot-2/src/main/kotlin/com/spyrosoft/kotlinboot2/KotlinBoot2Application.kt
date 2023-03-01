package com.spyrosoft.kotlinboot2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinBoot2Application

fun main(args: Array<String>) {
    runApplication<KotlinBoot2Application>(*args)
}
