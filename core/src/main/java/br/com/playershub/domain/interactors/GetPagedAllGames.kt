package br.com.playershub.domain.interactors

import br.com.playershub.domain.boundary.GamesBoundary
import javax.inject.Inject

class GetPagedAllGames @Inject constructor(
    private val repository: GamesBoundary
) {
    fun invoke() = repository.getPagedGamesDataSource()
}