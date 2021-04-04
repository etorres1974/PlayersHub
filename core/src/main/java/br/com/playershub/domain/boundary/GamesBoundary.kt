package br.com.playershub.domain.boundary

import br.com.playershub.data.rawgGamesApi.sources.GenericPagedDataSource
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

interface GamesBoundary {
    fun getPagedGamesDataSource(): GenericPagedDataSource<Game>
    fun getPagedUpcomingGamesDataSource(): GenericPagedDataSource<Game>
    fun getPagedTrendingGamesDataSource(): GenericPagedDataSource<Game>
    suspend fun detailGames(id: Int): GameDetails?
}