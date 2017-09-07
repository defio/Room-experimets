package com.nicoladefiorenze.room.business.datasource

import com.nicoladefiorenze.room.business.model.Email
import com.nicoladefiorenze.room.business.model.User
import com.nicoladefiorenze.room.database.Database
import io.reactivex.Flowable

/**
 * Project: Room<br/>
 * created on: 2017-05-24
 *
 * @author Nicola De Fiorenze
 */
class UserDataSource(val database: Database) {

    fun getAllUsers(): Flowable<User> {
        val userDao = database.userDao()
        val emailDao = database.emailDao()

        return userDao.getAllWithObservables()
                .flatMapIterable { it }
                .map { user ->
                    val userEmails = emailDao.getEmailsForUser(user.id).map { dbEmail ->
                        Email(dbEmail.email, dbEmail.isPrimary)
                    }
                    User(user.id, user.name, userEmails)

                }
    }

}