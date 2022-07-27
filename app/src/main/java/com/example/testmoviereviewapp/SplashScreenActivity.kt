package com.example.testmoviereviewapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        startAnotherActivity(this)
        setContentView(R.layout.activity_main)
    }
}

fun startAnotherActivity(context: Context) {
    context.startActivity(Intent(context, MainActivity::class.java))
}