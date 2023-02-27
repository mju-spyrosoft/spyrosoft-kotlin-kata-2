package com.spyrosoft.user

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

class UserController(private val userService: UserDto) {

    fun greetingRoute(route: Route) {
        route {
            route("/exposed/users") {
                // Create user
                post() {
                    val user = call.receive<User>()
                    val id = userService.create(user)
                    call.respond(HttpStatusCode.Created, id)
                }
                // Read user
                get("/{id}") {
                    val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
                    val user = userService.read(id)
                    if (user != null) {
                        call.respond(HttpStatusCode.OK, user)
                    } else {
                        call.respond(HttpStatusCode.NotFound)
                    }
                }
            }
        }
    }
}
