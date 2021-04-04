package br.com.playershub.data.rawgGamesApi

import androidx.paging.PageKeyedDataSource
import br.com.playershub.data.rawgGamesApi.clients.RawgGamesClient
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGamesResponse
import br.com.playershub.domain.entity.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrendingGamesPagedDataSource(
    private val client: RawgGamesClient = RawgGamesClient(),
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : PageKeyedDataSource<Int, Game>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Game>
    ) {
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = client.listGamesTrending(1, size).body()?.let {
                    callback.onResult(it.results ?: emptyList(), it.getPrevious(), it.getNext())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Game>) {
        val page = params.key
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = client.listPagedGames(page, size).body()?.let {
                    callback.onResult(it.results ?: emptyList(), it.getPrevious())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Game>) {
        val page = params.key
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = client.listPagedGames(page, size).body()?.let {
                    callback.onResult(it.results ?: emptyList(), it.getNext())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    //"https://api.rawg.io/api/games?key=128a503705e94b71836ebad8f7963efa&page=2&page_size=30"
    fun ApiGamesResponse.getPrevious() : Int?{
       return  previous?.split("page=")?.get(1)?.split("&")?.get(0)?.toIntOrNull()
    }

    fun ApiGamesResponse.getNext() : Int?{
        return  next?.split("page=")?.get(1)?.split("&")?.get(0)?.toIntOrNull()
    }


}