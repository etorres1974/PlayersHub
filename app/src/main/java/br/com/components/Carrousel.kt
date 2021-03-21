package br.com.components

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.playershub.GameAdapter

class Carrousel(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    init {
        adapter = GameAdapter()
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

}