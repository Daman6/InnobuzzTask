package com.example.innobuzztask.repo

import androidx.lifecycle.LiveData
import com.example.innobuzztask.api.RetrofitInstance
import com.example.innobuzztask.db.ResponseDatabse
import com.example.innobuzztask.model.ResponseDataModel
import com.example.innobuzztask.model.ResponseDataModelItem
import retrofit2.Response
import retrofit2.Retrofit

class DataRepo(
    val db : ResponseDatabse
) {


    suspend fun getAllData()=RetrofitInstance.api.getData()


    suspend fun upsert(response: ResponseDataModelItem)=db.getDataDao().upsert(response)

    fun getAllDataLocally()=db.getDataDao().getAllData()
}
