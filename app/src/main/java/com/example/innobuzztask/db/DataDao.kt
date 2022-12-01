package com.example.innobuzztask.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.innobuzztask.model.ResponseDataModel
import com.example.innobuzztask.model.ResponseDataModelItem

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(response : ResponseDataModelItem):Long

    @Query("Select * From response_Table")
    fun getAllData(): LiveData<List<ResponseDataModelItem>>
}