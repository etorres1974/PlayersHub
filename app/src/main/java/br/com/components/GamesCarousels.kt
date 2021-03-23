package br.com.components

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.playershub.domain.entity.Game

class GamesCarousels(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {

    fun setViewModel(viewModel: GamesViewModel){
        adapter = GameAdapter(viewModel::fetchGamesDetail)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun setSubmitGames(list : List<Game>?){
        (this.adapter as GameAdapter).submitList(list)
    }

}