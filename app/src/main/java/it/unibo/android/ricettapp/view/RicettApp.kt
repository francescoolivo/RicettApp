package it.unibo.android.ricettapp.view

import android.app.Application
import it.unibo.android.ricettapp.persistence.Repository

class RicettApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }
}