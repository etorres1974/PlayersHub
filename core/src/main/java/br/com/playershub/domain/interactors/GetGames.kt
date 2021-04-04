package br.com.playershub.domain.interactors

import br.com.playershub.domain.boundary.GamesBoundary
import javax.inject.Inject

class GetGames @Inject constructor(
    private val repository: GamesBoundary
) {

    suspend fun byId(id: Int) = repository.detailGames(id)
}