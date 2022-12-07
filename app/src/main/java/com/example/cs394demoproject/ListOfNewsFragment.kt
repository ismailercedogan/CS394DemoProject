package com.example.newsapp_cs394_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394demoproject.R
import com.example.cs394demoproject.adapter.ItemAdapter
import com.example.cs394demoproject.databinding.ListOfNewsLayoutBinding
import com.example.cs394demoproject.data.DataSource

class ListOfNewsFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ListOfNewsLayoutBinding>(inflater, R.layout.list_of_news_layout, container, false)
        val news = DataSource(requireActivity()).loadNews()

        val rv: RecyclerView = binding.recyclerView
        rv.adapter= ItemAdapter(news)



        return binding.root
    }
}