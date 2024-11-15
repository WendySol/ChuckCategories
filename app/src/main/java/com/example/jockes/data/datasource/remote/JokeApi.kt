package com.example.jockes.data.datasource.remote

import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {
    @GET("categories")
    suspend fun getCategories():Response<List<String>>
}