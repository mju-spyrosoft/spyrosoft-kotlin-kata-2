package com.spyrosoft.greeting

import kotlinx.serialization.Serializable

class GreetingsService(private val guestbook: MutableList<BookSign> = ArrayList()) {

    fun greet() = Greeting("Hello friend, welcome to kata")

    fun signGuestbook(sign: BookSign): BookSignResult {
        this.guestbook.add(sign)
        return BookSignResult("Thank you for signin our guest book ${sign.firstname}", guestbook.size)
    }

}

@Serializable
data class Greeting(val message:String)
@Serializable
data class BookSign(val firstname: String, val message: String)
@Serializable
data class BookSignResult(val message: String, val number: Int)
