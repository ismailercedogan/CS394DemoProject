package com.example.cs394demoproject.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cs394demoproject.model.News


@Dao
interface NewsHeadlinesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInsert(article: News): Long

    @Query("SELECT * FROM news")
    fun getAllArticles(): LiveData<List<News>>

    @Delete
    suspend fun deleteArticle(article: News)
}

