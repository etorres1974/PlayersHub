package br.com.playershub.domain.boundary

import br.com.playershub.domain.entity.Game

interface GamesBoundary {
    suspend fun listGames() : List<Game>?
    suspend fun detailGames(id : Int) : Game?
}