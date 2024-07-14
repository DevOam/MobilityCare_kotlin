package com.example.mobilitycare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilitycare.R
import android.os.Handler


class Splash_screen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000 // 3 secondes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Utilisation d'un Handler pour postposer l'Intent vers Login_screen
        Handler().postDelayed({
            val intent = Intent(this, Login_screen::class.java)
            startActivity(intent)
            finish() // Termine Splash_screen pour éviter de revenir avec le bouton Retour
        }, SPLASH_TIME_OUT)
    }
}

