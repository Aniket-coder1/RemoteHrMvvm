package com.example.remoteHR.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.remoteHR.R

class CustomProgressDialog(context: Context) : Dialog(context, R.style.Theme_AppCompat) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_dialog)
    }
}