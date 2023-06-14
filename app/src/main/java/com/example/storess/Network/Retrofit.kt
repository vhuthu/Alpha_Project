package com.example.storess.Network

import com.example.storess.Model.ProductsModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {
    private var retrofit: Retrofit? = null
    fun getRetrofitClient(baseUrl:String): Retrofit{

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        //here the httpclient will set time outs if the information we getting from the api is taking too long
        val okHttpClient : OkHttpClient = OkHttpClient.Builder()
            .readTimeout((60 * 2).toLong() , TimeUnit.SECONDS)
            .connectTimeout((60 * 2 ).toLong(), TimeUnit.SECONDS)
            .writeTimeout((60 * 2).toLong(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()


        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        }
        return retrofit!!
    }
}