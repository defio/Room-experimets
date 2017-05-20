package com.nicoladefiorenze.room.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database

/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun userDao(): UserDao
}