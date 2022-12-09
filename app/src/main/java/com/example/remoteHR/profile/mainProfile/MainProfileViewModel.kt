package com.example.remoteHR.profile.mainProfile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.remoteHR.network.HostURLs
import com.example.remoteHR.network.URLs
import com.example.remoteHR.others.Utility
import com.example.remoteHR.dataClass.data.*
import com.example.remoteHR.repository.MainRepository
import com.google.gson.Gson
import kotlinx.coroutines.*
import org.json.JSONObject

class MainProfileViewModel(application: Application) : AndroidViewModel(application) {

    var loginRepository: MainRepository = MainRepository()
    var _MainProfiledata = MutableLiveData<MainProfileResponse>()
    val MainProfiledata: LiveData<MainProfileResponse> = _MainProfiledata

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

    fun hitProfile() {
        isLoading.postValue(true)
        val jsonObject = JSONObject()
        jsonObject.put("", "")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
           isLoading.postValue(true)
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.user_profile)
            Utility.printMessage("URl " + HostURLs.host_name + URLs.user_profile)
            withContext(Dispatchers.Main) {
                if (response.body()!!.code == 200) {
                    isLoading.postValue(false)
                    _MainProfiledata.value = Gson().fromJson(
                        response.body()!!.data.toString(),
                        MainProfileResponse::class.java
                    )
                }
            }
        }
    }
}