package com.example.remoteHR.others

import android.content.Context
import com.example.remoteHR.others.Utility.Companion.printMessage

class PrefManager(var context: Context) {
    fun saveLoginDetails(email: String?, password: String?) {
        val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Email", email)
        editor.putString("Password", password)
        printMessage("login cred $email")
        printMessage("login cred $password")
        editor.commit()
    }

    val email: String?
        get() {
            val sharedPreferences =
                context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            return sharedPreferences.getString("Email", "")
        }
    val isUserLogedOut: Boolean
        get() {
            val sharedPreferences =
                context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            val isEmailEmpty = sharedPreferences.getString("Email", "")!!.isEmpty()
            val isPasswordEmpty = sharedPreferences.getString("Password", "")!!.isEmpty()
            return isEmailEmpty || isPasswordEmpty
        }

    fun clearRememberMe() {
        val preferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}