package com.example.bscsitsampleproject1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bscsitsampleproject1.databinding.ActivityRelavtiveLayoutBinding

class RelavtiveLayoutActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRelavtiveLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelavtiveLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initView(){
        binding.submitButton.setOnClickListener(this)
        binding.imgLogo
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.submitButton -> {

                // Implcit Intent
                startActivity(Intent(this, HorizontalAcitvity::class.java))

                //Explicit Intent
                val intentObj = Intent(Intent.ACTION_VIEW)
                intentObj.data = Uri.parse("https://www.google.com")
                startActivity(intentObj)

                // Explicit Intent

//                val emailIntent = Intent(Intent.ACTION_SEND)
//                emailIntent.setType("text/plain");
//                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
//                    "zainshah412.za@gmail.com");
//                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hello There");
//                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Add Message here");
//                emailIntent.type = "message/rfc822"
//
//                startActivity(Intent.createChooser(emailIntent, "zain.ali@auxilium.digital:"))

            }
        }
    }
}