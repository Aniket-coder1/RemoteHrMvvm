package com.example.remoteHR.fontClass


import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSpinner

class CustomSpinner(context: Context,attributes: AttributeSet) : AppCompatSpinner(context,attributes) {

    var listener: OnItemSelectedListener? = null
    override fun setSelection(position: Int) {
        super.setSelection(position)
        if (position == selectedItemPosition) {
            if (listener != null) {
                listener!!.onItemSelected(null, null, position, 0)
            }
        }
    }

    override fun setOnItemSelectedListener(listener: OnItemSelectedListener?) {
        this.listener = listener
    }

    init {
        this.background = null
    }
}