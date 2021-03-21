package br.com.playershub.domain.interactors

import br.com.playershub.data.rawgGamesApi.FreeToPlayGameRepository
import br.com.playershub.domain.boundary.GamesBoundary

class GetFreeGames(
    private val repository: GamesBoundary = FreeToPlayGameRepository()
) {
    suspend fun list() = repository.listGames()

    suspend fun byId(id: Int) = repository.detailGames(id)
}