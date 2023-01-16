package com.example.cs394demoproject.model

data class ApiResponse(
        val articles: MutableList<News>,
        val status: String,
        val totalResults: Int
)