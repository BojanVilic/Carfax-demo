package com.example.carfaxdemo.generic

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.carfaxdemo.R
import com.squareup.picasso.Picasso

/**Image url is returning an HTTP exception, code 404 both in the app and on the browser
 *I will use just a default error placeholder
 */

@BindingAdapter("urlImage")
fun bindUrlImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .fit()
        .error(R.drawable.no_image_found)
        .into(view)
}