package com.example.cs394demoproject.database.nhdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsHeadlinesEntity::class], version = 1)
abstract class NewsHeadlinesDB: RoomDatabase(){
    abstract  val newsHeadlinesDAO: NewsHeadlinesDAO
}
private lateinit var INSTANCE: NewsHeadlinesDB

fun getDatabase(context: Context): NewsHeadlinesDB {
    synchronized(NewsHeadlinesDB::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                NewsHeadlinesDB::class.java,
                "NewsHeadlinesRepo").build()
        }
    }
    return INSTANCE
}