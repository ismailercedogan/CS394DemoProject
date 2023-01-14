package com.example.cs394demoproject.newslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394demoproject.R
import com.example.cs394demoproject.databinding.ItemLayoutBinding
import com.example.cs394demoproject.databinding.ListOfNewsLayoutBinding
import com.example.cs394demoproject.network.NewsHeadlines
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.Glide

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<NewsHeadlines>() {
        override fun areItemsTheSame(oldItem: NewsHeadlines, newItem: NewsHeadlines): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: NewsHeadlines, newItem: NewsHeadlines): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent, false
            )
        )
    }

    private var onItemClickListener: ((String?) -> Unit)? = null

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val news = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(news.urlToImage).into(img_headline)
             R.id.sourceView.text= news.source.name
            R.id.titleView.text = news.title


            main_container.setOnItemClickListener {
                onItemClickListener?.let {
                    it(news.url)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setOnItemClickListener(listener: (String?) -> Unit) {
        onItemClickListener = listener
    }
}