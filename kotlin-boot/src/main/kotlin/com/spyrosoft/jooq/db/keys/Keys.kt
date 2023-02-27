/*
 * This file is generated by jOOQ.
 */
package com.spyrosoft.jooq.db.keys


import com.spyrosoft.jooq.db.tables.AppUser
import com.spyrosoft.jooq.db.tables.records.AppUserRecord

import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val APP_USER_PKEY: UniqueKey<AppUserRecord> = Internal.createUniqueKey(AppUser.APP_USER, DSL.name("app_user_pkey"), arrayOf(AppUser.APP_USER.ID), true)
