package com.example.cs394demoproject.fragments.newslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cs394demoproject.model.ApiResponse
import com.example.cs394demoproject.model.News
import com.example.cs394demoproject.network.ApiService
import com.example.cs394demoproject.repo.NewsHeadlinesRepo
import com.example.cs394demoproject.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsListViewModel(
        val newsRepository: NewsHeadlinesRepo
) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    var breakingNewsPage = 1
    var breakingNewsResponse: ApiResponse? = null

    val searchNews: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: ApiResponse? = null

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))

    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery, searchNewsPage)
        searchNews.postValue(handleSearchNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<ApiResponse>) : Resource<ApiResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                breakingNewsPage++
                if(breakingNewsResponse == null) {
                    breakingNewsResponse = resultResponse
                } else {
                    val oldArticles = breakingNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(breakingNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<ApiResponse>) : Resource<ApiResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                searchNewsPage++
                if(searchNewsResponse == null) {
                    searchNewsResponse = resultResponse
                } else {
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(searchNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle(article: News) = viewModelScope.launch {
        newsRepository.updateInsert(article)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteArticle(article: News) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}

class NewsViewModelProviderFactory(val newsRepository: NewsHeadlinesRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsListViewModel(newsRepository) as T
    }

}