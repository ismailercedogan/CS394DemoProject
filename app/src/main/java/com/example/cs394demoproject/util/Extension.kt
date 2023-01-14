package com.example.cs394demoproject.util

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.cs394demoproject.R

fun Fragment.openWebPage(newsUrl: String) {
    val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    builder.apply {
        setToolbarColor(ContextCompat.getColor(requireContext(), R.color.white))
        setShowTitle(true)
        setMenuVisibility(true)
    }
    customTabsIntent.launchUrl(requireContext(), Uri.parse(newsUrl))
}