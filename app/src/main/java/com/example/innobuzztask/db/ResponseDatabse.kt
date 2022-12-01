package com.example.innobuzztask.db

import android.content.Context
import androidx.room.*
import com.example.innobuzztask.model.ResponseDataModelItem

@Database(
    entities = [ResponseDataModelItem::class],
    version = 1,
    exportSchema = false
)

abstract class ResponseDatabse : RoomDatabase() {

    abstract fun getDataDao(): DataDao

    companion object{

        private var instance: ResponseDatabse? = null
        private val lock= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock)
        {
            instance ?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ResponseDatabse::class.java,
                "data_db.db"
            ).fallbackToDestructiveMigration()
                .build()

    }
}