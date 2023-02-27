package com.spyrosoft.greeting

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.greetingRoute(greetingsService: GreetingsService) {
    this {
        route("/greeting"){
            install(RequestValidation) {
                validate<BookSign> { bookSign ->
                    if (bookSign.firstname.isEmpty())
                        ValidationResult.Invalid("A customer ID should be greater than 0")
                    else ValidationResult.Valid
                }
            }
            get {
                val greetingResult = greetingsService.greet()
                call.respond(greetingResult)
            }
            post("/sign") {
                val bookSign = call.receive<BookSign>()
                val signGuestbookResult = greetingsService.signGuestbook(bookSign)
                call.respond(signGuestbookResult)
            }
        }
    }
}

