package br.com.playershub.data.rawgGamesApi

import androidx.paging.DataSource
import br.com.playershub.data.rawgGamesApi.clients.RawgGamesClient
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

class RawgVideoGameRepository(
    private val dataSource: RawgGamesClient = RawgGamesClient()
) : GamesBoundary {

    override suspend fun listGames(): List<Game>? {
        return dataSource.listGames().body()?.results
    }

    override suspend fun listGamesUpcoming(): List<Game>? {
        return dataSource.listGamesUpcoming().body()?.results
    }

    override suspend fun listGamesTrending(): List<Game>? {
        return dataSource.listGamesTrending().body()?.results
    }

    override suspend fun detailGames(id: Int): GameDetails? {
        return dataSource.detailGame(id).body()
    }
}