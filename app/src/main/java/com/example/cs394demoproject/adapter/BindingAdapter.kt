package com.example.mvvm_livedata_room

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.example.cs394demoproject.R
import com.example.cs394demoproject.util.Constants
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso


private const val BASE_URL = Constants.BASE_URL

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgPath = BASE_URL + imgUrl
        Log.v("BindingAdapter","$imgPath")
        val imgUri =
            imgPath.toUri().buildUpon().scheme("https").build()


        Picasso.get()
            .load(imgUri)
            .placeholder(R.drawable.not_available)
            .into(imgView)
    }
}


@BindingAdapter("app:errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}