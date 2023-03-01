package com.spyrosoft.kotlinboot2

import com.spyrosoft.jooq.db.tables.AppUser
import org.jooq.DSLContext
import org.jooq.Records
import org.springframework.stereotype.Component

@Component
class UserJooqRepository(private val dslContext: DSLContext) {

    private val APPUSER: AppUser = AppUser.APP_USER

    fun findById(id: Long): UserEntity? {
        return dslContext.select(APPUSER.ADDRESS, APPUSER.ID, APPUSER.FIRSTNAME, APPUSER.LASTNAME, APPUSER.EMAIL)
            .from(APPUSER)
            .where(APPUSER.ID.eq(id.toInt()))
            .fetchAny(Records.mapping { address, appUserId, firstName, lastName, email ->
                //Very sad face, no null safety support from jooq (YET)
                //https://github.com/jOOQ/jOOQ/issues/10212
                UserEntity(lastName!!, firstName!!, email!!, appUserId, address, )
            })
    }
}
