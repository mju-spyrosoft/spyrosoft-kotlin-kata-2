package com.spyrosoft.kotlinboot2

import org.springframework.stereotype.Service

@Service
class GuestService() {
    private val guestbook: MutableSet<String> = HashSet()

    fun greetAndAddToGuestBook(name: String): String {
        guestbook.add(name)
        return "hello kata: $name"
    }

    fun listGuests(): Set<String> {
        return guestbook.asSequence()
            .map { it.lowercase() }
            .toSet()
    }

}

