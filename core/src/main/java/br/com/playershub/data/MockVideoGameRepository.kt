package br.com.playershub.data

import br.com.playershub.data.rawgGamesApi.entity.ApiRawgGame
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

class MockVideoGameRepository : GamesBoundary { //Todo Change it to some test Lib

    override suspend fun listGames(): List<Game>? {
        return listOf(LOL, LOL, LOL, LOL)
    }

    override suspend fun detailGames(id: Int): GameDetails? {
        return LOL as GameDetails
    }
    companion object{
        val LOL = ApiRawgGame(
            id = 1,
            name = "League Of Legends",
            image = "https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/bltcfa4652c8d383f56/5e21837f63d1b6503160d39b/Home-page.jpg",
        )
    }
}