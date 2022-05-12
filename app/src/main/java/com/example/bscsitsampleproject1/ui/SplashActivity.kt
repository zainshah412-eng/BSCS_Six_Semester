package com.example.bscsitsampleproject1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AppApplication
import com.example.bscsitsampleproject1.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    private var coroutineScope: Job? = null
    private val NAVIGATION_DELAY = 1 * 1000L // 2 sec of delay
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        coroutineScope = CoroutineScope(Job() + Dispatchers.Main).launch {
            delay(NAVIGATION_DELAY)

            coroutineScope?.let {
                if (it.isActive) {
                    if (AppApplication.sessionManager.isLoggedIn) {
                        val intent = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }
}