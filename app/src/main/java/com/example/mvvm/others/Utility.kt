package com.example.mvvm.others

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mvvm.R
import com.example.mvvm.dialog.CustomDialog
import com.example.mvvm.dialog.CustomProgressDialog
import java.text.SimpleDateFormat
import java.util.*

class Utility {
    companion object {
        var isStartLog = false
        var logCatValue = ""

        fun printMessage(Message: String) {
            println("@@@CredilitySales@@@ : $Message")
            if (isStartLog) {
                logCatValue += """
            
            $Message
            """.trimIndent()
            }
        }

        fun getTimeStamp(): String? {
            val dateFormat = SimpleDateFormat("yyyymmddhhmmss")
            val date = dateFormat.format(Date())
            return "remoteHR_$date"
        }

        fun CustomLoader(context: Context): CustomProgressDialog {
            val progressDialog = CustomProgressDialog(context)
            progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            val window = progressDialog.window
            window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog.setCancelable(false)
            return progressDialog
        }

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = cm.activeNetworkInfo
            return if (ni == null) {
                // There are no active networks.
                false
            } else true
        }

        fun showToast(context: Context, msg: String, img: Int) {
            try {
                val customDialog = CustomDialog(context, msg, img)
                customDialog.show()
                customDialog.setCancelable(false)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}