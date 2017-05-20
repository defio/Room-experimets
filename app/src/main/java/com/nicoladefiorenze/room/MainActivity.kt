package com.nicoladefiorenze.room

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nicoladefiorenze.room.database.DatabaseProvider
import com.nicoladefiorenze.room.database.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg params: Void): Void? {
                var database = DatabaseProvider.getDatabase(applicationContext)

                val user1 = User()
                user1.name = "nicola"

                val userDao = database.userDao()
                userDao.insertAll(user1)

                val all = userDao.getAll()
                println(all)

                return null

            }
        }.execute()

    }
}
