package com.battot.mvi.common

import android.media.Image
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import com.battot.mvi.domain.model.Order


@BindingAdapter("android:order_image")
fun loadOrderImage(imageView: ImageView  , order: Order){
    ImageRequest.Builder(imageView.context)
        .data(order.image)
        .target(imageView)
        .crossfade(1000)
        .clip
        .build().apply {
            imageView.context.imageLoader.enqueue(this)
        }

}

@BindingAdapter("android:order_title")
fun loadOrderTitle(textView: TextView  , order: Order){
    textView.text = order.title
}


@BindingAdapter("android:order_price")
fun loadOrderPrice(textView: TextView  , order: Order){
    textView.text = order.price.toString()
}
