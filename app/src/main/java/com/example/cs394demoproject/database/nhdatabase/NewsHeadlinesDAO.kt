package com.example.cs394demoproject.database.nhdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao

interface NewsHeadlinesDAO {
    @Insert
    fun insert(source: NewsHeadlinesEntity)

    @Insert
    suspend fun insertAll(sources: List<NewsHeadlinesEntity>)

    @Query("SELECT * FROM NewsHeadlinesEntity")
    fun getAll(): LiveData<List<NewsHeadlinesEntity>>

    @Query("DELETE FROM NewsHeadlinesEntity")
    suspend fun deleteAll()
}