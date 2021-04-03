package br.com.util

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.playershub.R
import com.squareup.picasso.Picasso
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun ImageView.loadImageUrl(url : String){
    Picasso.get()
        .load(url)
        .fit()
        .error(R.drawable.ic_baseline_error_outline_24_material_red)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}