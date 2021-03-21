package br.com.playershub.domain.interactors

import br.com.playershub.data.RAWGVideoGame.RawgVideoGameRepository
import br.com.playershub.domain.boundary.RawgVideoGameBoundary

class GetGames(
    private val repository: RawgVideoGameBoundary = RawgVideoGameRepository()
){
    suspend fun list()  = repository.listGames()

    suspend fun byId(id : Int) = repository.detailGames(id)
}