package com.example.mvvm.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.R

class SplashScreen: AppCompatActivity() {
    private val SPLASH_SCREEN_TIME_OUT = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val i = Intent(
                this@SplashScreen,
                MainActivity::class.java
            )
            startActivity(i)
            finish()
        }, SPLASH_SCREEN_TIME_OUT.toLong())
    }
}