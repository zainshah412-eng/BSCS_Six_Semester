package com.example.bscsitsampleproject1.dbHelper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.bscsitsampleproject1.model.StudentModel

@RequiresApi(Build.VERSION_CODES.P)
class DBHelper(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "APL.db"
        val DATABASE_VERSION = 1

    }


    var Database: SQLiteDatabase? = null

    override fun onCreate(db: SQLiteDatabase?) {

    //TODO ============== Create Table Start ====================
        if (db != null) {
            db.execSQL(
                """CREATE TABLE IF NOT EXISTS  `studentsTable` (
      `id` Integer NOT NULL PRIMARY KEY AUTOINCREMENT,
      `rollNo` Integer DEFAULT NULL,
      `name` Text(50) DEFAULT NULL
    ) ;"""
            )
        }
    }

   fun initDB(){
       val db = this.readableDatabase
   }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // TODO Auto-generated method stub
        onCreate(p0)
    }

    fun insertPossibleConditions(student: StudentModel): Long? {
        var idInsert: Long = -1
        val db = this.readableDatabase
        try {
                val contentValues = ContentValues()
                contentValues.put("rollNo", student.id)
                contentValues.put("name", student.name)
                idInsert = db!!.insert("studentsTable", null, contentValues)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("_mLog", "insert Student error = " + e.message)
        } finally {
            db?.close()
        }
        return idInsert
    }

    fun deleteAllStudents(): Int {
        var idInsert = -1
        val sqlDeletePossibleConditions = "DELETE FROM studentsTable"
        val db = this.readableDatabase
        try {
            db!!.execSQL(sqlDeletePossibleConditions)
            idInsert = 1
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.d("_mLog", "insertStudent error = " + e.message)
        } finally {
            db?.close()
        }
        return idInsert
    }
    fun deleteSpecficStudent(rollNo: Int): Int {
        var idInsert = -1
        val sqlDeletePossibleConditions = "DELETE FROM studentsTable where plan_id= '" + rollNo + "'";
        val db = this.readableDatabase
        try {
            db!!.execSQL(sqlDeletePossibleConditions)
            idInsert = 1
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.d("_mLog", "insertStudent error = " + e.message)
        } finally {
            db?.close()
        }
        return idInsert
    }


    @SuppressLint("Range")
    fun getAllStudents(): ArrayList<StudentModel?>? {
        var res: Cursor? = null
        var list: ArrayList<StudentModel?>? = null
        var db: SQLiteDatabase? = null
        try {
            list = ArrayList<StudentModel?>()
            db = this.readableDatabase
            res = db.rawQuery("select * from studentsTable", null)
            res.moveToFirst()
            while (res.isAfterLast == false) {
                val student = StudentModel(res.getString(res.getColumnIndex("rollNo")),res.getString(res.getColumnIndex("name")))
                list!!.add(student)
                res.moveToNext()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            res?.close()
            db!!.close()
        }
        return list
    }


}