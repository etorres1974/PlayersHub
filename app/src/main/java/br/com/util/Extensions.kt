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

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}