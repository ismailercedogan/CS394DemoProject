package com.example.cs394demoproject

import com.example.cs394demoproject.model.News

interface SelectListener {
    fun OnNewsClicked(headlines: News?)
}