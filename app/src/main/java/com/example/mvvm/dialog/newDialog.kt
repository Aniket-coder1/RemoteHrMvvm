package com.example.mvvm.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.mvvm.R

class CustomDialog(context: Context, message: String, img: Int) : Dialog(context,R.style.transpaerttheme) {

    lateinit var tvMessage:TextView
    lateinit var btnOk: Button
    lateinit var ivImage: ImageView
    var messagee = message
    var image = img

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        tvMessage = findViewById(R.id.tvMessage)
        ivImage = findViewById(R.id.ivImage)
        try {
            ivImage.setImageResource(image)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        btnOk = findViewById(R.id.btnOk)
        tvMessage.text = messagee
        btnOk.setOnClickListener(View.OnClickListener { dismiss() })
    }

}