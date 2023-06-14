package com.example.storess.Common

import com.example.storess.Network.ApiService
import com.example.storess.Network.Retrofit
import retrofit2.create

object Common {
    private const val BASE_URL = "https://simplifiedcoding.net/demos/"
    val getApiService:ApiService
//https://simplifiedcoding.net/demos/  https://fakestoreapi.com/
        get() = Retrofit.getRetrofitClient(BASE_URL).create(ApiService::class.java)

}