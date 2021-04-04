package br.com.playershub.domain.interactors

import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import br.com.playershub.domain.boundary.GamesBoundary

class GetPagedTrendingGames(
    private val repository: GamesBoundary = RawgVideoGameRepository()
) {
    fun invoke() = repository.getPagedTrendingGamesDataSource()
}