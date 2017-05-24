package com.nicoladefiorenze.room

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.nicoladefiorenze.room.database.DatabaseProvider
import com.nicoladefiorenze.room.database.entity.Email
import com.nicoladefiorenze.room.database.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg params: Void): Void? {
                val database = DatabaseProvider.getDatabase(applicationContext)

                val user1 = User()
                user1.name = "nicola_${System.currentTimeMillis()}"

                val userDao = database.userDao()
                userDao.insertAll(user1)

                val all = userDao.getAll()
                println("Users: " + all)

                var email = Email()
                email.email = "${all.last().name}@gmail.com"
                email.isPrimary = true
                email.userId = all.last().id

                val emailDao = database.emailDao()
                emailDao.insertAll(email)

                emailDao.getEmailsForUser(all.last().id).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { list ->
                                    println(Thread.currentThread().name)
                                    println("email for ${all.last().id} " + list) },
                                { throwable -> println(throwable.message) })


                return null

            }
        }.execute()

    }
}
