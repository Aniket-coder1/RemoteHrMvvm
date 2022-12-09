package com.example.remoteHR.repository

import com.example.remoteHR.dataClass.mainResponseData.ResponseData
import com.example.remoteHR.network.ApiInterface
import com.example.remoteHR.others.Utility.Companion.printMessage
import com.example.remoteHR.spref.Spref
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response


class MainRepository {
    private var apiInterface = ApiInterface()

    //without token
    suspend fun getToken(para: JSONObject, url: String): Response<ResponseData> {
        return apiInterface.hitTokenApi(body(para),url)
    }

    //with token
    suspend fun getOthersData(para: JSONObject, url: String): Response<ResponseData> {
        return apiInterface.hitLoginApi(body(para),header(),url)
    }

    private fun body(parameter: JSONObject): RequestBody {
       return RequestBody.create("application/json; charset=utf-8".toMediaTypeOrNull(), parameter.toString())
    }
    private fun header(): MutableMap<String?, String?> {
        val hdr: MutableMap<String?, String?> = HashMap()
        hdr["Accept"] = "application/json"
        hdr["Authorization"]  = "Bearer ${Spref.getStringVal(Spref.TOKEN)}"
       // hdr["x-csrf-token"] = Spref.getStringVal(Spref.TOKEN)
        printMessage("token = $hdr")
        return hdr
    }
    /*companion object {
        fun getQuery(params: JSONObject): String {
            val first = true
            val set = params!!.valueSet()
            val itr: Iterator<*> = set.iterator()
            val jObj = JSONObject()
            while (itr.hasNext()) {
                val me = itr.next() as Map.Entry<*, *>
                try {
                    jObj.put(me.key.toString(), me.value.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            printMessage("json PARAMETERS : $jObj")
            return jObj.toString()
        }
    }*/
}