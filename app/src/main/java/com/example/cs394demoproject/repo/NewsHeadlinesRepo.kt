package com.example.cs394demoproject.repo
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.cs394demoproject.network.NewsHeadlines
import com.example.cs394demoproject.database.nhdatabase.NewsHeadlinesDB
import com.example.cs394demoproject.database.nhdatabase.asDomainModel
import com.example.cs394demoproject.network.NewsApi
import retrofit2.http.Query



class NewsHeadlinesRepo(private val database: NewsHeadlinesDB) {    suspend fun getRecentNews(countryCode: String, pageNum: Int) =
    NewsApi.retrofitService.getRecentNews(countryCode, pageNum)

    suspend fun searchNews(searchQuery: String, pageNum: Int) =
        NewsApi.retrofitService.searchAllNews(searchQuery, pageNum)
}