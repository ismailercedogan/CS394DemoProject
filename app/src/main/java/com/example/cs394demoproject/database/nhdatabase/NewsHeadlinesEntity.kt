package com.example.cs394demoproject.database.nhdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cs394demoproject.network.NewsHeadlines
import com.example.cs394demoproject.network.Source

@Entity
data class NewsHeadlinesEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImg: String?,
    val publishedAt: String?,
    val content: String?
)


fun List<NewsHeadlinesEntity>.asDomainModel(): List<NewsHeadlines>{
    return map{
        NewsHeadlines(
            id = it.id,
            source = it.source!!,
            author = it.author!!,
            title = it.title!!,
            description = it.description!!,
            url = it.url!!,
            urlToImage = it.urlToImg!!,
            publishedAt = it.publishedAt!!,
            content = it.content!!,
        )
    }
}