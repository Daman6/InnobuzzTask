package com.example.innobuzztask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "response_Table"
)
data class ResponseDataModelItem(
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)