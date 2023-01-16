package com.example.cs394demoproject.fragments.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cs394demoproject.fragments.newslist.NewsListViewModel
import com.example.cs394demoproject.MainActivity
import com.example.cs394demoproject.R
import com.example.cs394demoproject.databinding.NewsdetailsLayoutBinding
import com.squareup.picasso.Picasso

class NewsDetailsFragment : Fragment(R.layout.newsdetails_layout) {

    lateinit var viewModel: NewsListViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val binding = DataBindingUtil.inflate<NewsdetailsLayoutBinding>(
                inflater,
                R.layout.newsdetails_layout,
                container,
                false
        )

        viewModel = (activity as MainActivity).viewModel
        val selectedNews = args.article

        binding.textSource.text = selectedNews.title
        binding.textNewsDetail.text = selectedNews.description
        binding.textNewsTitle.text = selectedNews.title
        Picasso.get().load(selectedNews.urlToImage).into(binding.imgNews);

        return binding.root
    }


/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        //binding ve websiz

        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }*/

}