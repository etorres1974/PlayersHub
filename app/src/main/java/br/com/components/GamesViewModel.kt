package br.com.components

import androidx.lifecycle.LiveData
import br.com.playershub.domain.entity.Game

interface GamesViewModel {
    val openDetails: LiveData<Int>
    fun fetchGamesDetail(id : Int, name : String?)
}