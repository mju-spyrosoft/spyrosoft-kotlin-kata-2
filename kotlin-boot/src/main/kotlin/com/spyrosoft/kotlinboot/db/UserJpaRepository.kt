package com.spyrosoft.kotlinboot.jpa

import com.spyrosoft.kotlinboot.db.User
import org.springframework.data.repository.CrudRepository

interface UserJpaRepository : CrudRepository<User, Long>


