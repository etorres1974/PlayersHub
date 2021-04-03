package br.com.playershub.domain.boundary

import androidx.paging.DataSource
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

interface GamesBoundary {
    suspend fun listGames(): List<Game>?
    suspend fun listGamesUpcoming(): List<Game>?
    suspend fun listGamesTrending(): List<Game>?
    suspend fun detailGames(id: Int): GameDetails?
}