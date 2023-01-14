package com.example.cs394demoproject.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394demoproject.R
import com.example.cs394demoproject.database.nhdatabase.NewsHeadlinesDB
import com.example.cs394demoproject.databinding.ListOfNewsLayoutBinding
import com.example.cs394demoproject.network.ApiService
import com.example.cs394demoproject.network.NewsApiResponse
import com.example.cs394demoproject.network.NewsHeadlines
import com.example.cs394demoproject.network.OnFetchDataListener
import android.widget.Toast
import androidx.navigation.fragment.navArgs

class ListOfNewsFragment:Fragment() {
    private lateinit var viewModel: NewsVeiwModel
    //to get the argument as a global variable, do this
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        //get the articles
        // val article = args.article

        // display the article in the webview
        webView.apply {
            webViewClient = WebViewClient()
            //  loadUrl(article.url)
        }



    }

}