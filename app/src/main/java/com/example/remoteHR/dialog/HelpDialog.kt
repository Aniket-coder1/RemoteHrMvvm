package com.example.remoteHR.dialog

import android.app.Dialog
import android.content.Context
import android.os.Build.*
import android.os.Bundle
import com.example.remoteHR.R
import com.example.remoteHR.databinding.HelpDialogBinding


class HelpDialog(
    context: Context,
    private val deviceId: String?,
    private val latitude: String,
    private val longitude: String
) : Dialog(context, R.style.transpaerttheme) {

    lateinit var binding: HelpDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HelpDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLat.text = latitude
        binding.tvLong.text = longitude
        binding.tvDeviceId.text = deviceId
        binding.tvModel.text = "$BRAND $MODEL"
        binding.btnOk.setOnClickListener { dismiss() }
    }
}