package br.com.playershub.data.rawgGamesApi.clients

import br.com.playershub.data.rawgGamesApi.entity.ApiRawgGame
import br.com.playershub.data.rawgGamesApi.entity.ApiPlatform
import br.com.playershub.data.rawgGamesApi.entity.GameResponse
import br.com.playershub.data.rawgGamesApi.entity.PlatformResponse
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import retrofit2.Response

class RawgGamesClient : RawgGamesApiDataSource {

    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = RawgGamesApiDataSource::class.java,
        authInterceptor = RawgGamesApiInterceptor()
    )

    override suspend fun listPlatforms(): Response<PlatformResponse> {
        return client.listPlatforms()
    }

    override suspend fun detailPlatform(id: Int): Response<ApiPlatform> {
        return client.detailPlatform(id)
    }

    override suspend fun listGames(): Response<GameResponse> {
        return client.listGames()
    }

    override suspend fun detailGame(id: Int): Response<ApiRawgGame> {
        return client.detailGame(id)
    }
}