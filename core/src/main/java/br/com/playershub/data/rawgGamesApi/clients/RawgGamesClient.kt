package br.com.playershub.data.rawgGamesApi.clients

import br.com.playershub.data.rawgGamesApi.entity.*
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.API_KEY
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_HOST
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import okhttp3.HttpUrl
import retrofit2.Response
import retrofit2.http.Url
import java.net.URL

class RawgGamesClient {
    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl =  VIDEO_GAME_DB_URL,
        apiServiceInterface = RawgGamesApiDataSource::class.java,
        authInterceptor = RawgGamesApiInterceptor()
    )

    suspend fun listPlatforms(): Response<PlatformResponse> {
        return client.listPlatforms()
    }

    suspend fun detailPlatform(id: Int): Response<ApiPlatform> {
        return client.detailPlatform(id)
    }

    suspend fun listGames(): Response<GameResponse> {
        return client.listGames()
    }

    suspend fun detailGame(id: Int): Response<ApiRawgGameDetails> {
        return client.detailGame(id)
    }
}