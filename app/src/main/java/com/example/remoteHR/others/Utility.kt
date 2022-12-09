package com.example.remoteHR.others

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.Window
import android.view.WindowManager
import com.example.remoteHR.dialog.CustomDialog
import com.example.remoteHR.dialog.CustomProgressDialog
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