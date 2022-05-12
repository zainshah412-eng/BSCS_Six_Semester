package com.example.bscsitsampleproject1.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.bscsitsampleproject1.R
import com.example.bscsitsampleproject1.dbHelper.DBHelper
import com.example.bscsitsampleproject1.model.StudentModel

class AddStudentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var name: EditText
    private lateinit var rollNo: EditText
    private lateinit var buttonAdd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        initView()
    }

    private fun initView(){
        name = findViewById(R.id.etName)
        rollNo = findViewById(R.id.etRollNo)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonAdd.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onClick(p0: View?) {
        when(p0){
            buttonAdd ->{
                var studentModel = StudentModel(
                    rollNo.text.toString(),
                    name.text.toString()
                )
                DBHelper(applicationContext).insertPossibleConditions(studentModel)
            }
        }
    }
}