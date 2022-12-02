package com.example.mvvm.dashBoard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.R
import com.example.mvvm.SharedPreferences
import com.example.mvvm.dataClass.dashboardData.MainResponse
import com.example.mvvm.network.HostURLs
import com.example.mvvm.network.URLs
import com.example.mvvm.others.PrefManager
import com.example.mvvm.others.Utility
import com.example.mvvm.others.Utility.Companion.printMessage
import com.example.mvvm.repository.MainRepository
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONObject

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    val mainResponseLogout = MutableLiveData<JsonArray>()
    var loginRepository: MainRepository = MainRepository()
    val mainResponseCode = MutableLiveData<String>()
    var mainResponseMsg: String = ""
    var _dashboarddata = MutableLiveData<MainResponse>()
    val dashboarddata: LiveData<MainResponse> = _dashboarddata


    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}").toString()
    }
    private val errorMessage = MutableLiveData<String>()

    private fun onError(message: String) {
        errorMessage.postValue(message)
    }

    fun getDashboardData(dashboardFragment: DashboardFragment) {
        val jsonObject = JSONObject()
        jsonObject.put("", "")
        printMessage("parameter -$jsonObject")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.user_dashboard)
            printMessage("url- ${HostURLs.host_name + URLs.user_dashboard}")
            withContext(Dispatchers.Main) {
                when (response.body()!!.code) {
                    200 -> {
                        isLoading.postValue(false)
                        _dashboarddata.value = Gson().fromJson(
                            response.body()!!.data.toString(),
                            MainResponse::class.java
                        )
                    }
                    400 -> {
                        isLoading.postValue(false)
                        printMessage("Error message " + response.body()!!.message)
                        Utility.showToast(
                            dashboardFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                    else -> {
                        isLoading.postValue(false)
                        mainResponseMsg = response.message().toString()
                    }
                }
            }
        }
    }



    fun HitLogout() {
        val jsonObject = JSONObject()
        jsonObject.put("", "")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.logout)
            printMessage("URl " + HostURLs.host_name + URLs.logout)
            withContext(Dispatchers.Main) {
                if (response.body()!!.code == 200) {
                    isLoading.postValue(false)
                    PrefManager(getApplication()).clearRememberMe()
                    printMessage("logout success")
                    mainResponseLogout.postValue(response.body()!!.data)
                    mainResponseCode.postValue(response.code().toString())
                }
            }
        }
    }

    fun GetLogoutResponse(): MutableLiveData<JsonArray> {
        return mainResponseLogout
    }

    fun hitPunchIn(dashboardFragment: DashboardFragment) {
        try {
            val jsonObject = JSONObject()
            jsonObject.put("empId",  SharedPreferences.getIntPreference(getApplication(), SharedPreferences.EmpId))
            jsonObject.put("userType",  SharedPreferences.getStringPreference(getApplication(), SharedPreferences.UserType))
            jsonObject.put("punchValue", "In")
            jsonObject.put("fcm_token", "")
            jsonObject.put("deviceId", "378b53c37962352e")
            jsonObject.put("latitude", "19.1907856")
            jsonObject.put("longitude", "72.8371932")
            printMessage("punch request $jsonObject")
            CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                isLoading.postValue(true)
                val response = loginRepository.getOthersData(
                    jsonObject,
                    HostURLs.host_name + URLs.mark_attendance
                )
                printMessage("URl " + HostURLs.host_name + URLs.mark_attendance)
                withContext(Dispatchers.Main) {
                    if (response.body()!!.code == 200) {
                        isLoading.postValue(false)
                        printMessage("punch success")
                        Utility.showToast(
                            dashboardFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }else{
                        isLoading.postValue(false)
                        Utility.showToast(
                            dashboardFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                }
            }
        } catch (e: Exception) {
        }
    }
    fun hitPunchOut(dashboardFragment: DashboardFragment) {
        try {
            val jsonObject = JSONObject()
            jsonObject.put("empId",  SharedPreferences.getIntPreference(getApplication(), SharedPreferences.EmpId))
            jsonObject.put("userType",  SharedPreferences.getStringPreference(getApplication(), SharedPreferences.UserType))
            jsonObject.put("punchValue", "Out")
            jsonObject.put("fcm_token", "")
            jsonObject.put("deviceId", "378b53c37962352e")
            jsonObject.put("latitude", "19.1907856")
            jsonObject.put("longitude", "72.8371932")
            printMessage("punch request $jsonObject")
            CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                isLoading.postValue(true)
                val response = loginRepository.getOthersData(
                    jsonObject,
                    HostURLs.host_name + URLs.mark_attendance
                )
                printMessage("URl " + HostURLs.host_name + URLs.mark_attendance)
                withContext(Dispatchers.Main) {
                    if (response.body()!!.code == 200) {
                        isLoading.postValue(false)
                        printMessage("punch success")
                        Utility.showToast(
                            dashboardFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }else{
                        isLoading.postValue(false)
                        Utility.showToast(
                            dashboardFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                }
            }
        } catch (e: Exception) {
        }
    }
}