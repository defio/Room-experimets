package com.nicoladefiorenze.room.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.nicoladefiorenze.room.database.entity.Email
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
@Dao
interface EmailDao{

    @Query("SELECT * FROM email")
    fun getAll(): Flowable<List<Email>>

    @Query("SELECT * FROM email "
            + "INNER JOIN user ON user.id = email.user_id "
            + "WHERE user.id = :arg0")
    fun getEmailsForUser(userId: Int): Flowable<List<Email>>

    @Insert
    fun insertAll(vararg emails: Email)

    @Delete
    fun delete(email: Email)

}
