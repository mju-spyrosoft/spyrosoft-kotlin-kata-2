package com.spyrosoft.plugins

import com.spyrosoft.greeting.GreetingsService
import com.spyrosoft.greeting.greetingRoute
import com.spyrosoft.user.UserController
import com.spyrosoft.user.UserDto
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database as ExposedDatabase

/**
 * Uses kotlin dsl to construct routing
 */
fun Application.configureRouting() {

    val database = ExposedDatabase.Companion.connect(
        url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
        user = "root",
        driver = "org.h2.Driver",
        password = ""
    )

    val userService = UserDto(database)

    val greetingsService = GreetingsService()
    val userController = UserController(userService)

    routing {
        greetingRoute(greetingsService)             //passing dependencies to route (I like this more)
        userController.greetingRoute(this)    //passing routing to controller
    }
}


