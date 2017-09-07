package com.nicoladefiorenze.room.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.security.InvalidParameterException

/**
 * Project: Room<br></br>
 * created on: 2017-05-20

 * @author Nicola De Fiorenze
 */
@Entity(tableName = "email",
        foreignKeys = arrayOf(ForeignKey(
                entity = User::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("user_id"),
                onDelete = ForeignKey.CASCADE)))
class Email {
    @PrimaryKey
    var email: String = ""
    var isPrimary: Boolean = false

    @ColumnInfo(name = "user_id")
    var userId: Int = 0
}

