package com.example.remoteHR.activity

import android.app.Dialog
import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.ViewModelProvider
import com.example.remoteHR.databinding.ActivityLoginBinding
import com.example.remoteHR.dialog.HelpDialog

import com.example.remoteHR.spref.Spref
import com.example.remoteHR.others.Utility.Companion.CustomLoader
import com.example.remoteHR.mainLogin.LoginViewModel
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    open var context: Context? = null
    var progressBar: Dialog? = null
    lateinit var model: LoginViewModel
    var deviceID: String? = null
    var locationManager: LocationManager? = null
    var currentLat = 0.0
    var currentLong = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this
        Spref.getInstance(context!!)
        if (progressBar == null) progressBar = CustomLoader(this)
        model = ViewModelProvider(this)[LoginViewModel::class.java]
        model.isLoading.observe(this) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }

        deviceID = Settings.Secure.getString(
            this@MainActivity.contentResolver,
            Settings.Secure.ANDROID_ID
        )
        locationManager = this.getSystemService(LOCATION_SERVICE) as LocationManager
        try {
            val location = locationManager!!.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (location != null) {
                currentLat = location.latitude
                currentLong = location.longitude
                println("Lat :-$currentLat Long :- $currentLong")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showProgressBar() {
        if (progressBar != null) {
            progressBar!!.show()
        }
    }

    fun hideProgressBar() {
        if (progressBar != null && progressBar!!.isShowing) {
            progressBar!!.dismiss()
        }
    }
    fun showHelpDialog() {
        val helpDialog = HelpDialog(this@MainActivity, deviceID.toString(), currentLat.toString(), currentLong.toString())
        helpDialog.setCancelable(false)
        helpDialog.show()
    }
}