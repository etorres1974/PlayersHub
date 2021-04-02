package br.com.playershub.domain.interactors

import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import br.com.playershub.domain.boundary.GamesBoundary

class GetGames(
    private val repository: GamesBoundary = RawgVideoGameRepository()
) {
    suspend fun list() = repository.listGames()

    suspend fun upcoming() = repository.listGamesUpcoming()

    suspend fun byId(id: Int) = repository.detailGames(id)
}