package com.spyrosoft.kotlinboot.db

import jakarta.persistence.*

/**
 * Kotlin has classes andd their members final by default. For jpa they have "kotlin-jpa" plugin that automatically gets installed
 *
 * For other Spring AOP based stuff you can use their plugin called "kotlin-noarg"
 * https://docs.spring.io/spring-framework/docs/5.0.0.RELEASE/spring-framework-reference/kotlin.html#using-immutable-class-instances-for-persistence
 */
@Entity(name = "app_user")
class User(
    val firstname: String,
    val lastname: String,
    val email: String,
    address: String?,
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "app_user_id_seq"
    ) @SequenceGenerator(
        name = "app_user_id_seq",
        sequenceName = "app_user_id_seq",
        allocationSize = 1
    ) @Id var id: Long? = null,
) {
    var address = address
        set(value) {
            field = value?.replaceFirstChar { it.uppercase() }
        }

}
