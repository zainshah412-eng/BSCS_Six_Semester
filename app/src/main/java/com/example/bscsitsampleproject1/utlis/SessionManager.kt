package com.example.bscsitsampleproject1.utlis

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.bscsitsampleproject1.ui.MainActivity

class SessionManager(
    var _context: Context
) {
    var pref: SharedPreferences

    var editor: SharedPreferences.Editor

    var PRIVATE_MODE = 0

    /**
     * Create login session
     *
     * @param id is identification number of record data in database
     * @param name of user
     * @param work is title or role in company
     * @param about is simple description of user
     * @param username is a account id for credential
     * @param token is a secret key which generated from id and username
     */
    fun createLoginSession(
        email: String,
        password: String

    ) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(EMAIL, email)
        editor.putString(PASSWORD, password)
        editor.commit()
    }

    fun logoutUser() {
        editor.remove(IS_LOGIN)
        editor.remove(EMAIL)
        editor.remove(PASSWORD)

        // After logout redirect user to Login Activity
        val i = Intent(_context, MainActivity::class.java)
        // Closing all the Activities
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // Staring Login Activity
        _context.startActivity(i)
    }

    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)

     val email: String
     get() = pref.getString(EMAIL,"").toString()

    companion object {
        // Shared pref file name
        private const val PREF_NAME = "SPF_PREF"

        // All Shared Preferences Keys
        private const val IS_LOGIN = "IsLoggedIn"
        private const val EMAIL = "Email"
        private const val PASSWORD = "Password"
    }

    /**
     * Clear session details
     */
    fun clearPrefs() {
        editor.clear()
        editor.commit()
    }

    // Constructor
    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
        editor.apply()
    }
}