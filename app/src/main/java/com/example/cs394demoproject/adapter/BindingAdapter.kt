package com.example.mvvm_livedata_room

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cs394demoproject.R
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        Picasso.get()
            .load(imgUrl)
            .placeholder(R.drawable.not_available)
            .into(imgView)
    }
}


@BindingAdapter("app:errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage
}