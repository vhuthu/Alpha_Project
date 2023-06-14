package com.example.storess.Network

import com.example.storess.Model.ProductsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("marvel")
    fun getProductList(): Call<MutableList<ProductsModel>>
}