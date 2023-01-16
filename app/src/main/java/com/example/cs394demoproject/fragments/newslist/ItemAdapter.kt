package com.example.cs394demoproject.fragments.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cs394demoproject.R
import com.example.cs394demoproject.model.News

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = differ.currentList[position]

        val titleView = holder.itemView.findViewById<TextView>(R.id.titleView)
        val sourceView = holder.itemView.findViewById<TextView>(R.id.sourceView)
        val img = holder.itemView.findViewById<ImageView>(R.id.img_headline)

        holder.itemView.apply {
            Glide.with(this).load(news.urlToImage).into(img)
            sourceView.text = news.source?.name
            titleView.text = news.title


            setOnClickListener {
                onItemClickListener?.let { it(news) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((News) -> Unit)? = null

    fun setOnItemClickListener(listener: (News) -> Unit) {
        onItemClickListener = listener
    }
}