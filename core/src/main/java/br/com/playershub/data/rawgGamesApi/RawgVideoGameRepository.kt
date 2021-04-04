package br.com.playershub.data.rawgGamesApi

import br.com.playershub.data.rawgGamesApi.clients.RawgGamesClient
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails

class RawgVideoGameRepository(
    private val client: RawgGamesClient = RawgGamesClient(),
) : GamesBoundary {

    private lateinit var  pagedDataSource: GenericPagedDataSource<Game>

    fun listPaged(){
        pagedDataSource = GenericPagedDataSource<Game>(::listPagedGames)
    }

    suspend fun listPagedGames(page: Int, size: Int): List<Game>?{
        return client.listPagedGames(page, size).body()?.results
    }

    override suspend fun listGames(): List<Game>? {
        return client.listGames().body()?.results
    }

    override suspend fun listGamesUpcoming(): List<Game>? {
        return client.listGamesUpcoming().body()?.results
    }

    override suspend fun listGamesTrending(): List<Game>? {
        return client.listGamesTrending().body()?.results

    }

    override suspend fun detailGames(id: Int): GameDetails? {
        return client.detailGame(id).body()
    }
}