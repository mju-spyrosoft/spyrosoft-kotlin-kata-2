package com.spyrosoft.kotlinboot

import com.spyrosoft.kotlinboot.jpa.User
import com.spyrosoft.kotlinboot.jpa.UserJpaRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kata")
class KataController(
    private val guestBook: MutableList<PersonSign> = ArrayList(),
    private val userRepository: UserJpaRepository,
    private val apiConfiguration: ApiConfiguration
) { //Btw by kotlin collections are readonly BUT they are not immutable
    //If you want immutability use https://github.com/Kotlin/kotlinx.collections.immutable

    @GetMapping("/hey")
    fun heyKata(@RequestParam name: String?): String =
        if (name == null) "Hello again kata"
        else "Hello again $name, welcome nice to see you at kata"

    @GetMapping("/who-am-i")
    fun whoAmI(@RequestParam id: Long) = userRepository.findById(id)

    @PostMapping("/user")
    fun createUser(@RequestBody body: CreateUserBody): User {
        return userRepository.save(User(body.firstname, body.lastname, body.email, body.address, null))
    }

    @PostMapping("/user/{id}/address")
    fun changeAddress(@PathVariable id: String, @RequestBody body: ChangeAddressBody): User {
        val user = userRepository.findById(1).orElseThrow {
            IllegalStateException()
        }
        user.address = body.address

        return userRepository.save(user)
    }

    @PostMapping("/sign")
    fun signAsGuest(@RequestBody requestBody: PersonSign): BookSignResponseBody {
        guestBook.add(requestBody)
        return BookSignResponseBody("Thanks for signing our book ${requestBody.name}")
    }

    @GetMapping("/config-properties")
    fun callExternalApi(): ApiConfiguration {
        return apiConfiguration
    }
}

data class PersonSign(val name: String, val message: String?)
class BookSignResponseBody(val message: String)
class CreateUserBody(val firstname: String, val lastname: String, val email: String, val address: String)
class ChangeAddressBody(val address: String)


