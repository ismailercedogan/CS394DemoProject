package com.example.cs394demoproject.data

import android.content.Context
import com.example.cs394demoproject.R
import com.example.cs394demoproject.model.News

class DataSource (val context: Context) {
    fun getTitle(): Array<String> {
        return context.resources.getStringArray(R.array.title_array)
    }
    fun getDescription(): Array<String> {
        return context.resources.getStringArray(R.array.description_array)
    }
    fun getSource(): Array<String> {
        return context.resources.getStringArray(R.array.source_array)
    }

    fun loadNews(): List<News>{
        val titleList = getTitle()
        val descriptionList = getDescription()
        val sourceList = getSource()
        val news = mutableListOf<News>()

        for (i in 0..9){
            val country = News(titleList[i], descriptionList[i], sourceList[i])
            news.add(country)
        }
        return news
    }
}