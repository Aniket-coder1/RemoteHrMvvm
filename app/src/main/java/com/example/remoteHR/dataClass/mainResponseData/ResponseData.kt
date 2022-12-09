package com.example.remoteHR.dataClass.mainResponseData

import com.google.gson.JsonArray


data class ResponseData(
    val code: Int,
    val data: JsonArray,
    var message: String
)