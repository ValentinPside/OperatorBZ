package com.example.operatorbz.app

import android.app.Application
import com.example.operatorbz.di.AppComponent
import com.example.operatorbz.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}