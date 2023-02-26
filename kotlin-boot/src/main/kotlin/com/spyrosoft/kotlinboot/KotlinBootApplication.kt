package com.spyrosoft.kotlinboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(ApiConfiguration::class)
@SpringBootApplication
class KotlinBootApplication

fun main(args: Array<String>) {
	runApplication<KotlinBootApplication>(*args)
}
