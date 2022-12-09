package com.example.remoteHR.network

import com.example.remoteHR.dataClass.mainResponseData.ResponseData
import com.google.gson.JsonElement
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

    @POST
    @JvmSuppressWildcards
    suspend fun hitLoginApi(@Body parameter: RequestBody,@HeaderMap header: Map<String?, String?>?, @Url url: String):Response<ResponseData>
    @POST
    suspend fun hitTokenApi(@Body parameter: RequestBody, @Url url: String):Response<ResponseData>


    @Streaming
    @GET
    fun hitDownloadJsonElement(@Url fileUrl: String?): Call<JsonElement>

    @POST
    @JvmSuppressWildcards
    suspend fun hitApi(@Body parameter: RequestBody, @HeaderMap header: Map<String?, Any?>?, @Url url: String):Response<JsonElement>

    @JvmSuppressWildcards
    @Multipart
    @POST
    suspend fun hitApiImgVdoPdf(
        @Url api: String?,
        @HeaderMap header: Map<String?, Any?>?,
        @PartMap bodyMap: Map<String?, RequestBody?>?,
        @Part images: MultipartBody.Part?,
        @Part receiptImages: List<MultipartBody.Part?>?,
        @Part visitStatusImages: List<MultipartBody.Part?>?,
        @Part videos: List<MultipartBody.Part?>?
    ): Response<JsonElement>

    @JvmSuppressWildcards
    @Multipart
    @POST
    suspend fun hitApiImgVdo(
        @Url api: String?,
        @HeaderMap header: Map<String?, Any?>?,
        @PartMap bodyMap: Map<String?, RequestBody?>?,
        @Part images: List<MultipartBody.Part?>?,
        @Part receiptImages: List<MultipartBody.Part?>?,
        @Part visitStatusImages: List<MultipartBody.Part?>?,
        @Part videos: List<MultipartBody.Part?>?
    ): Response<JsonElement>

    @JvmSuppressWildcards
    @Multipart
    @POST
    suspend fun hitApiImage(@Url url: String, @HeaderMap header: MutableMap<String?, Any?>, @PartMap map: Map<String?, RequestBody?>,@Part imagePart: MutableList<MultipartBody.Part?>): Response<JsonElement>

    companion object{
        operator fun invoke():ApiInterface{
            return Retrofit.Builder()
                .baseUrl("https://hrm.bharatfinn.in/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
    }
}