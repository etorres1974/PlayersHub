package br.com.playershub.domain.interactors

import br.com.playershub.data.RawgVideoGameRepository
import br.com.playershub.data.rawgGamesApi.FreeToPlayGameRepository
import br.com.playershub.domain.boundary.GamesBoundary

class GetGames(
    private val repository: GamesBoundary = RawgVideoGameRepository()
) {
    suspend fun list() = repository.listGames()

    suspend fun byId(id: Int) = repository.detailGames(id)
}