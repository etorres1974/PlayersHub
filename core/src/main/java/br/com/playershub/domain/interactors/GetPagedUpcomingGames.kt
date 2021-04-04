package br.com.playershub.domain.interactors

import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import br.com.playershub.domain.boundary.GamesBoundary

class GetPagedUpcomingGames(
    private val repository: GamesBoundary = RawgVideoGameRepository()
) {
    fun invoke() = repository.getPagedUpcomingGamesDataSource()
}