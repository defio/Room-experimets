package com.nicoladefiorenze.room

import com.facebook.stetho.Stetho
import android.app.Application



/**
 * Project: Room<br/>
 * created on: 2017-05-25
 *
 * @author Nicola De Fiorenze
 */
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}