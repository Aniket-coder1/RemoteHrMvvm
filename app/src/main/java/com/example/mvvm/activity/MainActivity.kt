package com.example.mvvm.activity

import android.app.Dialog
import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityLoginBinding
import com.example.mvvm.dialog.HelpDialog

import com.example.mvvm.spref.Spref
import com.example.mvvm.others.Utility.Companion.CustomLoader
import com.example.mvvm.mainLogin.LoginViewModel
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
            this@MainActivity.getContentResolver(),
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