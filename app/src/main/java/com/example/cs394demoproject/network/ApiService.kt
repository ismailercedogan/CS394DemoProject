package com.example.cs394demoproject.network

import com.example.cs394demoproject.model.ApiResponse
import com.example.cs394demoproject.util.Constant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL="https://newsapi.org/v2/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit=Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService  {

    @GET("v2/top-headlines")
    suspend fun getRecentNews(
        @Query("country")
        countryCode: String,

        @Query("page")
        pageNum: Int = 1,

        @Query("apiKey")
        apiKey: String = Constant.API_KEY

    ) : Call<ApiResponse>
    @GET("v2/top-headlines")
    suspend fun searchAllNews(
        @Query("q")
        searchWord: String,

        @Query("page")
        pageNum: Int = 1,

        @Query("apiKey")
        apiKey: String = Constant.API_KEY

    ): Call<ApiResponse>

}

object NewsApi {
    val retrofitService :ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}



