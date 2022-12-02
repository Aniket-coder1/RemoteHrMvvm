package com.example.mvvm

import android.content.Context
import java.util.*

class SharedPreferences {
    companion object {

        val appToken = "accessToken"
        val EmpId = "EmpId"
        val EmpCode = "EmpCode"
        val FullName = "FullName"
        val ContactNumber = "ContactNumber"
        val CompanyEmail = "CompanyEmail"
        val UserType = "UserType"


        fun getStringPreference(context: Context, key: String): String {
            return context.getSharedPreferences(
                Constants.sharedPreferenceName,
                Context.MODE_PRIVATE
            ).getString(key, "").toString()
        }


        fun setStringPreference(context: Context, key: String, value: String) {
            context.getSharedPreferences(Constants.sharedPreferenceName, Context.MODE_PRIVATE)
                .edit().putString(key, value).apply()
        }

        fun getIntPreference(context: Context, key: String): Int {
            return context.getSharedPreferences(
                Constants.sharedPreferenceName,
                Context.MODE_PRIVATE
            ).getInt(key, 0)
        }


        fun setIntPreference(context: Context, key: String, value: Int) {
            context.getSharedPreferences(Constants.sharedPreferenceName, Context.MODE_PRIVATE)
                .edit().putInt(key, value).apply()
        }


        fun getLongPreference(context: Context, key: String): Long {
            return context.getSharedPreferences(
                Constants.sharedPreferenceName,
                Context.MODE_PRIVATE
            )
                .getLong(key, Calendar.getInstance().getTimeInMillis())
        }

        fun setLongPreference(context: Context, key: String, value: Long) {
            context.getSharedPreferences(Constants.sharedPreferenceName, Context.MODE_PRIVATE)
                .edit().putLong(key, value).apply()
        }

        fun getBooleanPreference(context: Context, key: String): Boolean {
            return context.getSharedPreferences(
                Constants.sharedPreferenceName,
                Context.MODE_PRIVATE
            ).getBoolean(key, false)
        }

        fun setBooleanPreference(context: Context, key: String, value: Boolean) {
            context.getSharedPreferences(Constants.sharedPreferenceName, Context.MODE_PRIVATE)
                .edit().putBoolean(key, value).apply()
        }
    }
}