package com.spyrosoft.kotlinboot2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/kata"])
class GreetingController(private val userService: GuestService) {
    @GetMapping("/hey")
    fun helloKata(@RequestParam name: String, @RequestParam otherParam: String?): String {
        println(otherParam)
        return userService.greetAndAddToGuestBook(name)
    }

    @GetMapping("/guestbook")
    fun showGuests(): Set<String> {
        return userService.listGuests()
    }
}
