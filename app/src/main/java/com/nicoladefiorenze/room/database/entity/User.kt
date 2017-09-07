package com.nicoladefiorenze.room.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""
}
