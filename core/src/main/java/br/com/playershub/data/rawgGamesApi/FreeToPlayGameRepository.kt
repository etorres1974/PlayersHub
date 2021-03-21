package br.com.playershub.data.rawgGamesApi

import br.com.playershub.data.rawgGamesApi.clients.FreeToPlayGamesClient
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.entity.Game

class FreeToPlayGameRepository(
    private val dataSource: FreeToPlayGamesClient = FreeToPlayGamesClient()
) : GamesBoundary {

    override suspend fun listGames(): List<Game>? {
        return dataSource.listGames().body()
    }

    override suspend fun detailGames(id: Int): Game? {
        return dataSource.detailGame(id).body()
    }
}