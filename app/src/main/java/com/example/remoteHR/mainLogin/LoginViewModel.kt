package com.example.remoteHR.mainLogin

import android.annotation.SuppressLint
import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.remoteHR.R
import com.example.remoteHR.network.HostURLs
import com.example.remoteHR.network.URLs
import com.example.remoteHR.others.PrefManager
import com.example.remoteHR.others.Utility.Companion.printMessage
import com.example.remoteHR.others.Utility.Companion.showToast
import com.example.remoteHR.repository.MainRepository

import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONObject

@SuppressLint("StaticFieldLeak")
class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var inputUserId = MutableLiveData<String>()
    var inputPassword = MutableLiveData<String>()
    val rememberMe = MutableLiveData<Boolean>()
    val mainResponse = MutableLiveData<JsonArray>()
    val mainResponseError = MutableLiveData<String>()
    var email: String? = null
    var password: String? = null
    var loginRepository: MainRepository = MainRepository()
    var mainResponseMsg: String = ""


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

    init {
        rememberMe.value = false
        isLoading.value = false
    }

    fun getTokens(mainLogin: MainLogin) {
        email = inputUserId.value.toString()
        password = inputPassword.value.toString()
        printMessage("email--- $email")
        printMessage("password--- $password")

        val jsonObject = JSONObject()
        jsonObject.put("com_email", email)
        jsonObject.put("password", password)
        jsonObject.put("status", "1")
        // parameter.put("data", jsonObject.toString())
        hitLoginApi(jsonObject,mainLogin)
    }

    private fun hitLoginApi(jsonObject: JSONObject,mainLogin: MainLogin) {
        printMessage("parameter -$jsonObject")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response = loginRepository.getToken(jsonObject, HostURLs.host_name + URLs.Login)
            printMessage("url- ${HostURLs.host_name + URLs.Login}")
            withContext(Dispatchers.Main) {
                when (response.body()!!.code) {
                    200 -> {
                        isLoading.postValue(false)
                        if (rememberMe.value == true) {
                            inputUserId.value?.let { saveLoginDetails(it, inputPassword.value) }
                            printMessage("itsChecked")
                        }
                        mainResponse.postValue(response.body()!!.data)

                    }
                    400 -> {
                        showToast(mainLogin.requireContext(), response.body()!!.message, R.drawable.alert)
                        isLoading.postValue(false)
                        printMessage("Error message " + response.body()!!.message)
                        mainResponseError.postValue(response.code().toString())
                        mainResponseMsg = response.body()!!.message
                    }
                    500 -> {
                        isLoading.postValue(false)
                        mainResponseError.postValue(response.code().toString())
                    }
                    else -> {
                        mainResponseError.postValue("")
                        mainResponseMsg = ""
                    }
                }
            }
        }
    }

    fun GetResponse(): MutableLiveData<JsonArray> {
        return mainResponse
    }

    fun saveLoginDetails(email: String, password: String?) {
        PrefManager(getApplication()).saveLoginDetails(email, password)
    }
}