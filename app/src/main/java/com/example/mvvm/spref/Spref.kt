package com.example.mvvm.spref

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


object Spref {
    private var sharedPref: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    const val TOKEN = "token"
    const val FIREBASE_TOKEN = "firebase_token"
    const val REMEMBER_ME = "rememberMe"
    const val REMEMBER_BOOLEAN = "remember_boolean"
    const val EmpId = "EmpId"
    const val USER_EMAIL = "user_email"
    const val PREF_PASSWORD = "password"
    const val EmpCode = "EmpCode"
    const val FullName = "FullName"
    const val ContactNumber = "ContactNumber"
    const val CompanyEmail = "CompanyEmail"
    const val UserType = "UserType"

    @SuppressLint("CommitPrefEdits")
    fun getInstance(context: Context) {
        if (Spref.sharedPref == null) {
            Spref.sharedPref =
                context.getSharedPreferences(context.packageName + ".SPref", MODE_PRIVATE)
            Spref.editor = Spref.sharedPref!!.edit()
        }
    }
    //String Value return
    fun getStringVal(key: String?): String? {
        return Spref.sharedPref!!.getString(key, "")
    }

    fun getStringVal(key: String?, default: String?): String? {
        return Spref.sharedPref!!.getString(key, default)
    }

    fun getTrackerAppFetchTime(key: String?): Int {
        return Spref.sharedPref!!.getInt(key, 30)
    }

    fun getTrackerAppSyncTime(key: String?): Int {
        return Spref.sharedPref!!.getInt(key, 15)
    }

    /* fun getIsTeamLeader(key: String?):Int{
         return sharedPref!!.getInt(key,0)
     }*/


    fun putStringVal(key: String?, value: String?) {
        Spref.editor!!.putString(key, value).commit()
    }

    //Boolean Value Return
    fun getBooleanVal(key: String?): Boolean {
        return Spref.sharedPref!!.getBoolean(key, false)
    }

    fun getBooleanVal(key: String?, default: Boolean): Boolean {
        return Spref.sharedPref!!.getBoolean(key, default)
    }

    fun putBooleanVal(key: String?, value: Boolean) {
        Spref.editor!!.putBoolean(key, value).commit()
    }

    //Int Value Return
    fun getIntVal(key: String?): Int {
        return Spref.sharedPref!!.getInt(key, 0)
    }

    fun getIntVal(key: String?, value: Int): Int {
        return Spref.sharedPref!!.getInt(key, value)
    }

    fun putIntVal(key: String?, value: Int) {
        Spref.editor!!.putInt(key, value).commit()
    }

    //Long Value Return
    fun getLongVal(key: String?): Long {
        return Spref.sharedPref!!.getLong(key, 0)
    }

    fun getLongVal(key: String?, value: Long): Long {
        return Spref.sharedPref!!.getLong(key, value)
    }

    fun putLongVal(key: String?, value: Long) {
        Spref.editor!!.putLong(key, value).commit()
    }


    //Clear All Data
    fun clearAllSharedPreference() {
        Spref.editor?.clear()
        Spref.editor?.apply()
    }

    //Clear for Specific Data
    fun clear(key: String?) {
        Spref.editor?.remove(key)
        Spref.editor?.apply()
    }

}