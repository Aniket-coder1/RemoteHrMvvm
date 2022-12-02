package com.example.mvvm.reimbursement

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.R
import com.example.mvvm.network.HostURLs
import com.example.mvvm.network.URLs
import com.example.mvvm.others.Utility
import com.example.mvvm.repository.MainRepository
import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONObject

class ReimbursementViewModel(application: Application) : AndroidViewModel(application) {
    val mainResponse = MutableLiveData<JsonArray>()
    var loginRepository: MainRepository = MainRepository()
    var purpose = MutableLiveData<String>()
    var amount = MutableLiveData<String>()
    var fromDate = ""
    var toDate = ""
    val mainResponseError = MutableLiveData<String>()
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

    fun hitReimbursement(reimbursementFragment: ReimbursementFragment) {
        val jsonObject = JSONObject()
        jsonObject.put("purpose", purpose.value.toString())
        jsonObject.put("from_date", fromDate)
        jsonObject.put("to_date", toDate)
        jsonObject.put("reimbursement_amount", amount.value.toString())
        jsonObject.put("deviceType", "mobile")
        Utility.printMessage("request $jsonObject")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response = loginRepository.getOthersData(
                jsonObject,
                HostURLs.host_name + URLs.apply_reimbursement
            )
            Utility.printMessage("URl " + HostURLs.host_name + URLs.apply_reimbursement)
            withContext(Dispatchers.Main) {
                println("Data code " + response.body()!!.code)
                when (response.body()!!.code) {
                    200 -> {
                        isLoading.postValue(false)
                        Utility.showToast(reimbursementFragment.requireContext(),response.body()!!.message,R.drawable.img)
                    }
                    400 -> {
                        isLoading.postValue(false)
                        Utility.showToast(
                            reimbursementFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )

                    }
                    500 -> {
                        isLoading.postValue(false)
                        Utility.showToast(
                            reimbursementFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                }
            }
        }
    }
}