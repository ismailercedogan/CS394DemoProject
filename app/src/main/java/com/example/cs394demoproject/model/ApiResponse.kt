package com.example.cs394demoproject.model

import com.example.cs394demoproject.network.NewsHeadlines

class ApiResponse(val status:String, val totalResults:Int,val articles: MutableList<NewsHeadlines>,) :java.io.Serializable{
}