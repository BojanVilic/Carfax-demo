package com.example.carfaxdemo.generic

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.carfaxdemo.R
import com.squareup.picasso.Picasso


@BindingAdapter("urlImage")
fun bindUrlImage(view: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        Picasso.get()
            .load(imageUrl)
            .into(view)
    } else {
        view.setImageResource(R.drawable.ic_launcher_background)
    }
}