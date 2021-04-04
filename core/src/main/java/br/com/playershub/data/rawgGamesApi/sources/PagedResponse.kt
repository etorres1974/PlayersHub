package br.com.playershub.data.rawgGamesApi.sources

interface PagedResponse<T> {
    fun getData() : List<T>?
    fun getPrevious() : Int?
    fun getNext() : Int?
}