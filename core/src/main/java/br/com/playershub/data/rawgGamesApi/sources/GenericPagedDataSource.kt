package br.com.playershub.data.rawgGamesApi.sources

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class GenericPagedDataSource<T>(
    val fetchApiResponse: suspend (page: Int, size: Int) -> Response<PagedResponse<T>>,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : PageKeyedDataSource<Int, T>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = fetchApiResponse(1, size).body()?.let {
                    callback.onResult(it.getData() ?: emptyList(), it.getPrevious(), it.getNext())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        val page = params.key
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = fetchApiResponse(page, size).body()?.let {
                    callback.onResult(it.getData() ?: emptyList(), it.getPrevious())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        val page = params.key
        val size = params.requestedLoadSize
        scope.launch {
            try {
                val response = fetchApiResponse(page, size).body()?.let {
                    callback.onResult(it.getData() ?: emptyList(), it.getNext())
                }

            } catch (exception: Exception) {
                println("Factory Exception : $exception")
            }
        }
    }

    //"https://api.rawg.io/api/games?key=128a503705e94b71836ebad8f7963efa&page=2&page_size=30"
}