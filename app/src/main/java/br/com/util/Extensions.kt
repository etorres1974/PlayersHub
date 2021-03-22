package br.com.util

import android.widget.ImageView
import br.com.playershub.R
import com.squareup.picasso.Picasso

fun ImageView.loadImageUrl(url : String){
    Picasso.get()
        .load(url)
        .error(R.drawable.ic_baseline_error_outline_24_material_red)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}