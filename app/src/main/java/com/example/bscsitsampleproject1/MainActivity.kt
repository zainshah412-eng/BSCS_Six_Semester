package com.example.bscsitsampleproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        buttonSubmit = findViewById(R.id.submitButton)
        buttonSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            buttonSubmit -> {
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HorizontalAcitvity::class.java))
            }
        }
    }
}