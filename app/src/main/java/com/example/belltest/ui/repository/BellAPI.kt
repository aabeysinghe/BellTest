package com.example.fragmentcommunicate.api

import com.example.fragmentcommunicate.Pojo.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface BellAPI {

    @GET("/mobile/v2/apps/mobile")
    fun getMovies(): Call<Movies>

    @GET("/mobile/v2/apps/screen/{namespace}/{alias}")
    fun getScreen(@Path("namespace") namespace: String , @Path("alias") alias: String): Call<PojoTwo>

    @GET("/mobile/v2/collection/{namespace}/{alias}")
    fun getThird(@Path("namespace") namespace: String , @Path("alias") alias: String): Call<MovieSummary>

}