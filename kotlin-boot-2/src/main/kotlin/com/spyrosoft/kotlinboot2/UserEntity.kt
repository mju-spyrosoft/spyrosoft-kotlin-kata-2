package com.spyrosoft.kotlinboot2

import jakarta.persistence.*
import java.util.*

@Entity(name = "app_user")
class UserEntity(
    val lastname: String,
    val firstname: String,
    val email: String,
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_user_id_seq")
    @SequenceGenerator(name = "app_user_id_seq", sequenceName = "app_user_id_seq", allocationSize = 1)
    @Id
    private val id: Int? = null,
    var address: String? = null
) {

    fun getAddressButCooler(): String? = address?.let { upperEven(it) }

    companion object {
        //Not mine code, dont shout at me
        private fun upperEven(s: String): String {
            val c = s.toCharArray()
            var t = false
            for (i in c.indices) if (Character.isLetter(c[i])) c[i] =
                if (!t.also { t = it }) c[i].lowercaseChar() else c[i].uppercaseChar()
            return String(c)
        }
    }
}
