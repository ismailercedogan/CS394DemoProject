package com.example.cs394demoproject.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cs394demoproject.R
import com.example.cs394demoproject.databinding.NewsdetailsLayoutBinding
import com.squareup.picasso.Picasso

class NewsDetailsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<NewsdetailsLayoutBinding>(inflater, R.layout.newsdetails_layout, container, false)
        val args = NewsDetailsFragmentArgs.fromBundle(requireArguments())
        val selectedNews = args.news

        binding.textSource.text = selectedNews.title
        binding.textNewsDetail.text = selectedNews.description
        binding.textNewsTitle.text = selectedNews.title
        Picasso.get().load(selectedNews.urlToImage).into(binding.imgNews);


        return binding.root
    }
}