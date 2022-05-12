package com.example.bscsitsampleproject1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.AppApplication
import com.example.bscsitsampleproject1.R

class LoginActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var buttonSubmit: Button
    private lateinit var et_login_email: EditText
    private lateinit var et_login_password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView(){
        buttonSubmit = findViewById(R.id.buttonSubmit)
        et_login_email = findViewById(R.id.et_login_email)
        et_login_password = findViewById(R.id.et_login_password)
        buttonSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            buttonSubmit -> {
                AppApplication.sessionManager.createLoginSession(et_login_email.text.toString(),et_login_password.text.toString())
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}