package br.com.playershub.data.RAWGVideoGame

import br.com.playershub.data.RAWGVideoGame.clients.RawgGamesClient
import br.com.playershub.domain.boundary.RawgVideoGameBoundary
import br.com.playershub.domain.entity.Game

class RawgVideoGameRepository(
    private val dataSource: RawgGamesClient = RawgGamesClient()
) : RawgVideoGameBoundary {

    override suspend fun listGames(): List<Game>? {
        return dataSource.listGames().body()?.results
    }

    override suspend fun detailGames(id : Int): Game? {
        return dataSource.detailGame(id).body() ?: MockVideoGameRepository().detailGames(1)
    }
}