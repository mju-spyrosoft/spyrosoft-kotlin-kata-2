package com.spyrosoft.kotlinboot2

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["/users"])
class UserController(private val userRepository: UserRepository) {


    @PostMapping
    fun createUser(@RequestBody user: CreateUserBody): UserEntity {
        val entity = UserEntity(user.lastname, user.firstname, user.email, address = user.address)
        return userRepository.save(entity)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String?): Optional<UserEntity> {
        return userRepository.findById(Integer.valueOf(id))
    }
}

data class CreateUserBody(val firstname: String, val lastname: String, val address: String?, val email: String)

