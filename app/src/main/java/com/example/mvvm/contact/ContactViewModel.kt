package com.example.mvvm.contact

import android.app.Application
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

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val mainResponse = MutableLiveData<JsonArray>()
    var loginRepository: MainRepository = MainRepository()
    var contactListData: ArrayList<ContactData> = ArrayList()
    var contactList = MutableLiveData<ArrayList<ContactData>>()

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

    fun getContactList(contactFragment: ContactFragment) {
        isLoading.postValue(true)
        val jsonObject = JSONObject()
        jsonObject.put("", "")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.employee_list)
            Utility.printMessage("url- ${HostURLs.host_name + URLs.employee_list}")
            withContext(Dispatchers.Main) {
                isLoading.postValue(false)
                when (response.body()!!.code) {

                    200 -> {
                        isLoading.postValue(false)
                        mainResponse.postValue(response.body()!!.data)
                        val jsonArray: JsonArray = response.body()!!.data
                        println("list response : $jsonArray")
                        for (i in 0 until jsonArray.size()) {
                            val jsonElement = jsonArray[i]
                            val jsonObject = jsonElement.asJsonObject
                            /*if (jsonObject.has("headerName")) {
                                tvTitle.setText(jsonObject["headerName"].asString)
                            }*/
                            if (jsonObject.has("employeeList")) {
                                val jsonArray1 = jsonObject.getAsJsonArray("employeeList")
                                for (j in 0 until jsonArray1.size()) {
                                    val contactData = ContactData()
                                    val jsonElement1 = jsonArray1[j]
                                    val jsonObject1 = jsonElement1.asJsonObject
                                    if (jsonObject1.has("displayName")) {
                                        contactData.displayName =
                                            jsonObject1["displayName"].asString
                                    }
                                    if (jsonObject1.has("contactNumber")) {
                                        contactData.contactNumber =
                                            jsonObject1["contactNumber"].asString
                                    }
                                    if (jsonObject1.has("companyEmail")) {
                                        contactData.companyEmail =
                                            jsonObject1["companyEmail"].asString
                                    }
                                    if (jsonObject1.has("profilePhoto")) {
                                        contactData.profilePhoto =
                                            jsonObject1["profilePhoto"].asString
                                    }
                                    if (jsonObject1.has("designation")) {
                                        contactData.designation =
                                            jsonObject1["designation"].asString
                                    }
                                    contactListData.add(contactData)
                                    contactList.postValue(contactListData)
                                }
                            }
                        }
                    }
                    400 -> {
                        isLoading.postValue(false)
                        Utility.printMessage("Error message " + response.body()!!.message)
                        Utility.showToast(
                            contactFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                    else -> {
                        isLoading.postValue(false)
                        Utility.showToast(
                            contactFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                }
            }
        }
    }
}
