package com.nicoladefiorenze.room.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.nicoladefiorenze.room.database.dao.EmailDao
import com.nicoladefiorenze.room.database.dao.UserDao
import com.nicoladefiorenze.room.database.entity.Email
import com.nicoladefiorenze.room.database.entity.User

/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
@Database(entities = arrayOf(User::class, Email::class), version = 3)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun emailDao(): EmailDao
}