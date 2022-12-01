package com.example.innobuzztask.api

import com.example.innobuzztask.model.ResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface dataApi {

    @GET("posts")
    suspend fun getData():Response<ResponseDataModel>
}