package com.example.testmoviereviewapp.app

import android.app.Application
import com.example.testmoviereviewapp.di.AppComponent
import com.example.testmoviereviewapp.di.DaggerAppComponent

class MoviesApp: Application() {


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}