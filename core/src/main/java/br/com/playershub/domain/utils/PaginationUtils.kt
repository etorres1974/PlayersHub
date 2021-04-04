package br.com.playershub.domain.interactors

import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import br.com.playershub.data.rawgGamesApi.sources.GenericPagedDataSource

fun <T> getPagedLiveData(dataSource: GenericPagedDataSource<T>) = LivePagedListBuilder(
    getFactory(dataSource),
    configPagination()
).build()

fun <T> getFactory(dataSource: GenericPagedDataSource<T>): DataSource.Factory<Int, T> {
    return object : DataSource.Factory<Int, T>() {
        override fun create(): DataSource<Int, T> {
            return dataSource
        }
    }
}

fun configPagination() = PagedList.Config.Builder()
    .setPageSize(5)
    .setEnablePlaceholders(true)
    .build()