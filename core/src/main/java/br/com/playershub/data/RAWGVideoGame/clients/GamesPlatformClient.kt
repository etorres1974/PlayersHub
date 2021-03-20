package br.com.playershub.data.RAWGVideoGame.clients

import br.com.playershub.data.RAWGVideoGame.entity.ApiPlatform
import br.com.playershub.data.RAWGVideoGame.entity.PlatformResponse
import br.com.playershub.data.RAWGVideoGame.interceptors.GameApiInterceptor
import br.com.playershub.data.RAWGVideoGame.sources.GamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import retrofit2.Response

class GamesPlatformClient : GamesApiDataSource {

    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = GamesApiDataSource::class.java,
        authInterceptor = GameApiInterceptor()
    )

    override suspend fun listPlatforms(): Response<PlatformResponse> {
        return client.listPlatforms()
    }

    override suspend fun detailPlatform(id: Int): Response<ApiPlatform> {
        return client.detailPlatform(id)
    }
}