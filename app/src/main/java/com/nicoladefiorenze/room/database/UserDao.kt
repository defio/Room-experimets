package com.nicoladefiorenze.room.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


/**
 * Project: Room<br/>
 * <br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}