package com.example.cs394demoproject.repo

import com.example.cs394demoproject.network.RetrofitInstance
import com.example.cs394demoproject.database.NewsHeadlinesDB
import com.example.cs394demoproject.model.News


class NewsHeadlinesRepo(
        val db: NewsHeadlinesDB
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
            RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun updateInsert(article: News) = db.getNewsDao().updateInsert(article)

    fun getSavedNews() = db.getNewsDao().getAllArticles()

    suspend fun deleteArticle(article: News) = db.getNewsDao().deleteArticle(article)

}

