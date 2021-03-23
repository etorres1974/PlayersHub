package br.com.components

import androidx.lifecycle.LiveData
import br.com.playershub.domain.entity.Game

interface GamesViewModel {
    val games: LiveData<List<Game>>
    fun fetchGamesDetail(id : Int)
}