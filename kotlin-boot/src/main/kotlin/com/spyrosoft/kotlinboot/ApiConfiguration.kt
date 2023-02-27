package com.spyrosoft.kotlinboot

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "externalapi")
class ApiConfiguration(
    val clientId: String,
    val url: String
)
