package com.nicoladefiorenze.room

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.nicoladefiorenze.room.business.datasource.UserDataSource
import com.nicoladefiorenze.room.database.DatabaseProvider
import com.nicoladefiorenze.room.database.entity.Email
import com.nicoladefiorenze.room.database.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Project: Room<br/>
 * created on: 2017-05-20
 *
 * @author Nicola De Fiorenze
 */
class MainActivity : AppCompatActivity() {

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = DatabaseProvider.getDatabase(applicationContext)


        UserDataSource(database).getAllUsers().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread())
                .subscribe(
                        { user -> println(user) },
                        { error -> println(error.message) }
                )


    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
