package br.com.playershub.data.RAWGVideoGame

import br.com.playershub.data.RAWGVideoGame.entity.ApiGame
import br.com.playershub.domain.boundary.RawgVideoGameBoundary
import br.com.playershub.domain.entity.Game

class MockVideoGameRepository : RawgVideoGameBoundary { //Todo Change it to some test Lib

    override suspend fun listGames(): List<Game>? {
        return listOf(LOL, LOL, LOL, LOL)
    }

    override suspend fun detailGames(id: Int): Game? {
        return LOL
    }
    companion object{
        val LOL = ApiGame(
            id = 1,
            name = "League Of Legends",
            dominantColor = "#DECE7E",
            saturatedColor = "#0F202C",
            backgroundImage = "https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/bltcfa4652c8d383f56/5e21837f63d1b6503160d39b/Home-page.jpg",
        )
    }
}