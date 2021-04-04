package br.com.playershub.data.rawgGamesApi

import br.com.playershub.data.rawgGamesApi.clients.RawgGamesClient
import br.com.playershub.data.rawgGamesApi.sources.GenericPagedDataSource
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

class RawgVideoGameRepository(
    private val client: RawgGamesClient = RawgGamesClient()
) : GamesBoundary {

    override fun getPagedGamesDataSource(): GenericPagedDataSource<Game> {
        return GenericPagedDataSource(client::listPagedGames)
    }

    override fun getPagedUpcomingGamesDataSource(): GenericPagedDataSource<Game> {
        return GenericPagedDataSource(client::listGamesUpcoming)
    }

    override fun getPagedTrendingGamesDataSource(): GenericPagedDataSource<Game> {
        return GenericPagedDataSource(client::listGamesTrending)
    }

    override suspend fun detailGames(id: Int): GameDetails? {
        return client.detailGame(id).body()
    }
}