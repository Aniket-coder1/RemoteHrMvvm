package com.example.mvvm.liveList

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.R
import com.example.mvvm.SharedPreferences
import com.example.mvvm.dataClass.leaveListData.LeaveListData
import com.example.mvvm.network.HostURLs
import com.example.mvvm.network.URLs
import com.example.mvvm.others.Utility
import com.example.mvvm.repository.MainRepository
import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONObject

class LeaveListViewModel(application: Application) : AndroidViewModel(application) {
    val mainResponse = MutableLiveData<JsonArray>()
    var loginRepository: MainRepository = MainRepository()
    var mainResponseMsg: String = ""
    var leaveListData: ArrayList<LeaveListData> = ArrayList()
    var leaveList = MutableLiveData<ArrayList<LeaveListData>>()
    var pos = 0

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

    fun hitLeaveListData(leaveListFragment: LeaveListFragment) {
        isLoading.postValue(true)
        val jsonObject = JSONObject()
        jsonObject.put(
            "empId",
            SharedPreferences.getIntPreference(getApplication(), SharedPreferences.EmpId)
        )
        jsonObject.put("deviceType", "mobile")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.list_leave)
            Utility.printMessage("url- ${HostURLs.host_name + URLs.list_leave}")
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
                            if (jsonObject.has("empLeaveList")) {
                                val jsonArray1 = jsonObject.getAsJsonArray("empLeaveList")
                                for (j in 0 until jsonArray1.size()) {
                                    leaveListData.clear()
                                    val jsonElement1 = jsonArray1[j]
                                    val jsonObject1 = jsonElement1.asJsonObject
                                    if (jsonObject1.has("All")) {
                                        val jsonArray2 = jsonObject1.getAsJsonArray("All")
                                        for (k in 0 until jsonArray2.size()) {
                                            val leavelist = LeaveListData()
                                            Utility.printMessage("Size :- " + jsonArray2.size())
                                            val jsonElement2 = jsonArray2[k]
                                            val jsonObject3 = jsonElement2.asJsonObject
                                            if (jsonObject3.has("id")) {
                                                leavelist.id = jsonObject3["id"].asString
                                            }
                                            if (jsonObject3.has("reason")) {
                                                leavelist.reason = jsonObject3["reason"].asString
                                            }
                                            if (jsonObject3.has("leaveName")) {
                                                leavelist.leaveName =
                                                    jsonObject3["leaveName"].asString
                                            }
                                            if (jsonObject3.has("fromDate")) {
                                                leavelist.fromDate =
                                                    jsonObject3["fromDate"].asString
                                            }
                                            if (jsonObject3.has("toDate")) {
                                                leavelist.toDate = jsonObject3["toDate"].asString
                                            }
                                            if (jsonObject3.has("noOfDays")) {
                                                leavelist.noOfDays =
                                                    jsonObject3["noOfDays"].asString
                                            }
                                            if (jsonObject3.has("approvalStatus")) {
                                                leavelist.approvalStatus =
                                                    jsonObject3["approvalStatus"].asString
                                            }
                                            if (jsonObject3.has("textColor")) {
                                                leavelist.textColor =
                                                    jsonObject3["textColor"].asString
                                            }
                                            if (jsonObject3.has("textBackgroundColor")) {
                                                leavelist.textBackgroundColor =
                                                    jsonObject3["textBackgroundColor"].asString
                                            }
                                            if (jsonObject3.has("delete_leave_url")) {
                                                leavelist.deleteLeaveUrl =
                                                    jsonObject3["delete_leave_url"].asString
                                            }
                                            if (jsonObject3.has("leave_id")) {
                                                leavelist.leaveId = jsonObject3["leave_id"].asString
                                            }
                                            leaveListData.add(leavelist)
                                            leaveList.postValue(leaveListData)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    400 -> {
                        isLoading.postValue(false)
                        Utility.printMessage("Error message " + response.body()!!.message)
                        Utility.showToast(
                            leaveListFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                    }
                    else -> {
                        isLoading.postValue(false)
                        Utility.showToast(
                            leaveListFragment.requireContext(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                        mainResponseMsg = response.message().toString()
                    }
                }
            }
        }
    }

    fun hitDeleteApi(position: Int) {
        pos = position
        val jsonObject = JSONObject()
        jsonObject.put("leave_id", leaveListData[pos].leaveId)
        Utility.printMessage("delete json ${jsonObject.toString()}")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response =
                loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.leaveDelete)
            Utility.printMessage("url- ${HostURLs.host_name + URLs.leaveDelete}")
            withContext(Dispatchers.Main) {
                when (response.body()!!.code) {
                    200 -> {
                        isLoading.postValue(false)
                        mainResponse.postValue(response.body()!!.data)
                        hitLeaveListData(leaveListFragment = LeaveListFragment())
                    }
                    400 -> {
                        isLoading.postValue(false)
                        Utility.printMessage("Error message " + response.body()!!.message)
                        Toast.makeText(
                            getApplication(),
                            response.body()!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else -> {
                        isLoading.postValue(false)
                        Toast.makeText(
                            getApplication(),
                            response.body()!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                        mainResponseMsg = response.message().toString()
                    }
                }
            }
        }
    }
}