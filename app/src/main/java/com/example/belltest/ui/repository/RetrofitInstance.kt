package com.example.fragmentcommunicate.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https:raacestg.entpay.9c9media.ca/"
class RetrofitInstance {

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .client(okHttpClient)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
    }

    val api by lazy {
        retrofit.create(BellAPI::class.java)
    }




}