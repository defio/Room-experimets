package com.nicoladefiorenze.room.database

import android.arch.persistence.room.Room
import android.content.Context


/**
 * Project: Room<br/>
 * <br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
object DatabaseProvider {

    private var db: Database? = null

    fun getDatabase(context: Context): Database {
        if (db == null) {
            return Room.databaseBuilder(context, Database::class.java, "experimental-database").build()
        }
        return db!!
    }

}