package com.example.remoteHR.leave

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.remoteHR.R
import com.example.remoteHR.SharedPreferences
import com.example.remoteHR.dataClass.leaveData.FromSession
import com.example.remoteHR.dataClass.leaveData.LeaveType
import com.example.remoteHR.dataClass.leaveData.ToSession
import com.example.remoteHR.network.HostURLs
import com.example.remoteHR.network.URLs
import com.example.remoteHR.others.Utility
import com.example.remoteHR.repository.MainRepository
import com.google.gson.JsonArray
import kotlinx.coroutines.*
import org.json.JSONObject
import java.util.*

class LeaveViewModel(application: Application) : AndroidViewModel(application) {

    val mainResponse = MutableLiveData<JsonArray>()
    var mainResponseMsg: String = ""
    var leaveTypeId = ""
    var reason = MutableLiveData<String>()
    var fromDate = ""
    var toDate = ""
    var contact = MutableLiveData<String>()
    var fromSessionsId = ""
    var toSessionsId = ""
    var loginRepository: MainRepository = MainRepository()
    var leaveTypeModelArrayList: ArrayList<LeaveType> = ArrayList()
    var leaveType = MutableLiveData<ArrayList<LeaveType>>()
    var fromSessionDataArrayList: ArrayList<FromSession> = ArrayList()
    var fromsession = MutableLiveData<ArrayList<FromSession>>()
    var toSessionDataArrayList: ArrayList<ToSession> = ArrayList()
    var toSession = MutableLiveData<ArrayList<ToSession>>()
    val mainResponseError = MutableLiveData<String>()


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

    fun hitGetLeavedata() {
        try {
            val jsonObject = JSONObject()
            jsonObject.put(
                "empId",
                SharedPreferences.getIntPreference(getApplication(), SharedPreferences.EmpId)
            )
            jsonObject.put("deviceType", "mobile")
            CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                isLoading.postValue(true)
                val response =
                    loginRepository.getOthersData(jsonObject, HostURLs.host_name + URLs.my_leave)
                Utility.printMessage("url- ${HostURLs.host_name + URLs.my_leave}")
                withContext(Dispatchers.Main) {
                    when (response.body()!!.code) {

                        200 -> {
                            isLoading.postValue(false)
                            mainResponse.postValue(response.body()!!.data)
                            val jsonArray: JsonArray = response.body()!!.data!!
                            println("Document response : $jsonArray")
                            leaveTypeModelArrayList.clear()
                            fromSessionDataArrayList.clear()
                            toSessionDataArrayList.clear()
                            for (i in 0 until jsonArray.size()) {
                                val jsonElement = jsonArray[i]
                                val jsonObject = jsonElement.asJsonObject
                                /*if (jsonObject.has("headerName")) {
                                    tvTitle!!.text = jsonObject["headerName"].asString
                                }*/
                                if (jsonObject.has("leaveTypeList")) {
                                    val jsonArray1 = jsonObject.getAsJsonArray("leaveTypeList")
                                    for (j in 0 until jsonArray1.size()) {
                                        val leaveTypeModel = LeaveType()
                                        val jsonElement1 = jsonArray1[j]
                                        val jsonObject1 = jsonElement1.asJsonObject
                                        if (jsonObject1.has("leave_type_id")) {
                                            leaveTypeModel.leaveTypeId =
                                                jsonObject1["leave_type_id"].asString
                                        }
                                        if (jsonObject1.has("displayName")) {
                                            leaveTypeModel.displayName =
                                                jsonObject1["displayName"].asString
                                        }
                                        leaveTypeModelArrayList.add(leaveTypeModel)
                                        leaveType.postValue(leaveTypeModelArrayList)
                                        println("model.leaveTypeModelArrayList  1: $leaveTypeModelArrayList")
                                    }
                                }
                                if (jsonObject.has("from_session")) {
                                    val jsonArray1 = jsonObject.getAsJsonArray("from_session")
                                    for (j in 0 until jsonArray1.size()) {
                                        val fromSessionData = FromSession()
                                        val jsonElement1 = jsonArray1[j]
                                        val jsonObject1 = jsonElement1.asJsonObject
                                        if (jsonObject1.has("from_session")) {
                                            fromSessionData.from_session =
                                                jsonObject1["from_session"].asString
                                        }
                                        if (jsonObject1.has("displayName")) {
                                            fromSessionData.displayNm1 =
                                                jsonObject1["displayName"].asString
                                        }
                                        fromSessionDataArrayList.add(fromSessionData)
                                        fromsession.postValue(fromSessionDataArrayList)
                                    }
                                }
                                if (jsonObject.has("to_session")) {
                                    val jsonArray1 = jsonObject.getAsJsonArray("to_session")
                                    for (j in 0 until jsonArray1.size()) {
                                        val toSessionData = ToSession()
                                        val jsonElement1 = jsonArray1[j]
                                        val jsonObject1 = jsonElement1.asJsonObject
                                        if (jsonObject1.has("to_session")) {
                                            toSessionData.to_session =
                                                jsonObject1["to_session"].asString
                                        }
                                        if (jsonObject1.has("displayName")) {
                                            toSessionData.displayNm2 =
                                                jsonObject1["displayName"].asString
                                        }
                                        toSessionDataArrayList.add(toSessionData)
                                        toSession.postValue(toSessionDataArrayList)
                                    }
                                }
                            }
                        }
                        400 -> {
                            isLoading.postValue(false)
                            Utility.printMessage("Error message " + response.body()!!.message)
                            Toast.makeText(
                                getApplication<Application>().applicationContext,
                                response.body()!!.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        else -> {
                            isLoading.postValue(false)
                            Utility.printMessage("Error message " + response.body()!!.message)
                            mainResponseMsg = response.message().toString()
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
    }

    fun hitApply() {
        val jsonObject = JSONObject()
        jsonObject.put("leave_type_id", leaveTypeId)
        jsonObject.put("reason", reason.value.toString())
        jsonObject.put("from_date", fromDate)
        jsonObject.put("to_date", toDate)
        jsonObject.put("contact_detail", contact.value.toString())
        jsonObject.put("from_session", fromSessionsId)
        jsonObject.put("to_session", toSessionsId)
        jsonObject.put("deviceType", "mobile")
        println("Apply leave json $jsonObject")
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            isLoading.postValue(true)
            val response = loginRepository.getOthersData(
                jsonObject,
                HostURLs.host_name + URLs.apply_leave
            )
            Utility.printMessage("URl " + HostURLs.host_name + URLs.apply_leave)
            withContext(Dispatchers.Main) {
                println("Data code " + response.body()!!.code)
                when (response.body()!!.code) {
                    200 -> {
                        isLoading.postValue(false)
                        Utility.printMessage("Error message 0" + response.body()!!.message)
                    }
                    400 -> {
                        Utility.showToast(
                            getApplication(),
                            response.body()!!.message,
                            R.drawable.alert
                        )
                        isLoading.postValue(false)
                        Utility.printMessage("Error message 1" + response.body()!!.message)
                        mainResponseMsg = response.body()!!.message
                    }
                    500 -> {
                        isLoading.postValue(false)
                        Utility.printMessage("Error message 2" + response.body()!!.message)
                        mainResponseError.postValue(response.code().toString())
                    }
                    else -> {
                        mainResponseError.postValue("")
                        Utility.printMessage("Error message 3" + response.body()!!.message)
                        mainResponseMsg = ""
                    }
                }
            }

        }
    }
}