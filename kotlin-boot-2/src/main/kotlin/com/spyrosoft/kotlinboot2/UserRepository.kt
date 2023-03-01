package com.spyrosoft.kotlinboot2

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Int>
