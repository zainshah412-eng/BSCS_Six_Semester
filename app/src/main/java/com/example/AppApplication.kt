package com.example

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.bscsitsampleproject1.dbHelper.DBHelper
import com.example.bscsitsampleproject1.utlis.SessionManager

class AppApplication : Application() {
    private val TAG = AppApplication::class.simpleName
    companion object {
        lateinit var instance: Application
        lateinit var sessionManager: SessionManager
        lateinit var dbHelper: DBHelper
    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun initialize() {
        instance = this
        sessionManager = SessionManager(applicationContext)
     //   dbHelper = DBHelper(applicationContext)
//        val dbHelper = DBHelper(this)
//        dbHelper.initDB()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}