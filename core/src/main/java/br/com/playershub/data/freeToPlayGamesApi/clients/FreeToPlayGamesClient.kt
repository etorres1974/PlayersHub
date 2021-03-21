package br.com.playershub.data.rawgGamesApi.clients

import br.com.playershub.data.freeToPlayGamesApi.entity.ApiFreeToPlayGame
import br.com.playershub.data.rawgGamesApi.interceptors.FreeToPlayInterceptor
import br.com.playershub.data.freeToPlayGamesApi.sources.FreeToPlayDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.FREE_TO_PLAY_URL
import retrofit2.Response

class FreeToPlayGamesClient : FreeToPlayDataSource {

    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = FREE_TO_PLAY_URL,
        apiServiceInterface = FreeToPlayDataSource::class.java,
        authInterceptor = FreeToPlayInterceptor()
    )

    override suspend fun listGames(): Response<List<ApiFreeToPlayGame>> {
        return client.listGames()
    }

    override suspend fun detailGame(id: Int): Response<ApiFreeToPlayGame> {
        return client.detailGame(id)
    }
}