package br.com.playershub.data

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

    override suspend fun detailGames(id: Int): GameDetails? {
        return dataSource.detailGame(id).body() as GameDetails
    }
}