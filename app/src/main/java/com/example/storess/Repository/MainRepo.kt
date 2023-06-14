package com.example.storess.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.storess.Common.Common
import com.example.storess.Model.ProductsModel
import com.example.storess.Network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {

    private val apiService:ApiService

    companion object{
        private const val TAG = "MainRepo"
    }

    init {
        apiService = Common.getApiService
    }

    val getProductsModelLiveData: MutableLiveData<MutableList<ProductsModel>>
        get() {
            val data: MutableLiveData<MutableList<ProductsModel>> =
                MutableLiveData<MutableList<ProductsModel>>()
            apiService.getProductList().enqueue(object : Callback<MutableList<ProductsModel>>{
                override fun onResponse(
                    call: Call<MutableList<ProductsModel>>,
                    response: Response<MutableList<ProductsModel>>
                ) {
                    Log.e(TAG,"onResponse: " + response.code())
                    if (response.isSuccessful){
                        data.value = response.body()!!
                    }else{
                        data.value = null
                    }
                }

                override fun onFailure(call: Call<MutableList<ProductsModel>>, t: Throwable) {
                    Log.e(TAG,"onResponse: " + t.message)
                    data.value = null
                }

            })
            return data
        }
}