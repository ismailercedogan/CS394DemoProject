package com.example.cs394demoproject.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cs394demoproject.repo.NewsHeadlinesRepo

class NewsListViewModelFactory (val newsRepository: NewsHeadlinesRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsListViewModel (newsRepository) as T
    }
}