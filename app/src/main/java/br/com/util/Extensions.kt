package br.com.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImageUrl(url : String){
    Picasso.get().load(url).into(this)
}