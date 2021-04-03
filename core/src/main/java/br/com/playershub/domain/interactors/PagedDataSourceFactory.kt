package br.com.playershub.domain.interactors

import androidx.paging.DataSource
import br.com.playershub.data.rawgGamesApi.GamesPagedDataSource
import br.com.playershub.domain.entity.Game

object PagedDataSourceFactory : DataSource.Factory<Int, Game>() {

    override fun create(): DataSource<Int, Game> {
        return GamesPagedDataSource()
    }
}