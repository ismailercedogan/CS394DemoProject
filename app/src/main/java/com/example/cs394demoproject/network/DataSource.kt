package com.example.cs394demoproject.network

import com.example.cs394demoproject.database.nhdatabase.NewsHeadlinesEntity
import com.squareup.moshi.Json


class NewsApiResponse(val status:String, val totalResults:Int,val articles:List<NewsHeadlines>)

data class Source(
    val id: Int = 0,
    @Json(name = "id") val id_name: String? = null,
    val name: String? = null){
}

data class NewsHeadlines(val id: Int, val source: Source, val author: String, val title:String, val description: String, val url: String, val urlToImage: String, val publishedAt: String, val content: String): java.io.Serializable


fun NewsApiResponse.asDatabaseModel(): List<NewsHeadlinesEntity>{
    return articles.map{
        NewsHeadlinesEntity(
            id = it.id,
            source = it.source,
            author = it.author,
            title = it.title,
            description = it.description,
            url = it.url,
            urlToImg = it.urlToImage,
            publishedAt = it.publishedAt,
            content = it.content,
        )
    }
}