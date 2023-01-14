package com.example.cs394demoproject.newslist

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.example.cs394demoproject.model.ApiResponse
import com.example.cs394demoproject.network.NewsApi
import com.example.cs394demoproject.repo.NewsHeadlinesRepo
import com.example.cs394demoproject.util.Resource
import retrofit2.Call
import retrofit2.Response

enum class NewsApiResponseStatus { LOADING, ERROR, DONE }

class NewsListViewModel(private val  newsRepository: NewsHeadlinesRepo) : ViewModel() {

    val recentNews: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    val pageNum = 1

    val searchNews: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()
    val searchNewsPageNum = 1


    init {
        getrecentNews("tr")
    }

    //function to get the recent nws from the API

    fun getrecentNews(countryCode: String) =
        viewModelScope.launch {
            recentNews.postValue(Resource.Loading())
            //make network response
            val response = newsRepository.getRecentNews(countryCode, pageNum)
            recentNews.postValue(handleRecentNewsResponse(response))

        }

    fun searchNews(searchQuery: String) =
        viewModelScope.launch {
            searchNews.postValue(Resource.Loading())
            val response =  newsRepository.searchNews(searchQuery, pageNum)
            searchNews.postValue(handleSearchNewsResponse(response))
        }

    //function to handle the response & pagination
    private fun handleRecentNewsResponse(response: Response<ApiResponse>): Resource<ApiResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return  Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<ApiResponse>): Resource<ApiResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return  Resource.Error(response.message())
    }
}

