package com.example.bscsitsampleproject1.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.bscsitsampleproject1.R
import com.example.bscsitsampleproject1.adapter.RecyclerViewAdapter
import com.example.bscsitsampleproject1.dbHelper.DBHelper
import com.example.bscsitsampleproject1.model.StudentModel

class MainActivity : AppCompatActivity(), View.OnClickListener,
    RecyclerViewAdapter.StudentClickListener {
    private lateinit var recyclerView: RecyclerView
    var studentAdapter: RecyclerViewAdapter? = null
    var studentList: ArrayList<StudentModel> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        initView()
        setRecyclerViewData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_favorite ->{
                Toast.makeText(this, "Action favorite", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings ->{

                true
            }
            R.id.action_share ->{
                Toast.makeText(this, "Action Kiran", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun initView(){
        recyclerView = findViewById(R.id.recyclerView)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setRecyclerViewData(){
        studentList = DBHelper(applicationContext).getAllStudents() as ArrayList<StudentModel>
        studentAdapter = RecyclerViewAdapter(this,studentList,this)
        recyclerView.adapter = studentAdapter
    }

    override fun onClick(p0: View?) {
        when(p0){

        }
    }

    override fun onStudentClick(position: Int, itemAtPos: StudentModel) {

    }
}