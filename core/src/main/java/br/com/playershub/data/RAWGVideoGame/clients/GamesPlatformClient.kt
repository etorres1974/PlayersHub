package br.com.playershub.data.RAWGVideoGame.clients

import br.com.playershub.data.RAWGVideoGame.entity.ApiGame
import br.com.playershub.data.RAWGVideoGame.entity.ApiPlatform
import br.com.playershub.data.RAWGVideoGame.entity.GameResponse
import br.com.playershub.data.RAWGVideoGame.entity.PlatformResponse
import br.com.playershub.data.RAWGVideoGame.interceptors.GameApiInterceptor
import br.com.playershub.data.RAWGVideoGame.sources.GamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import retrofit2.Response

class GamesPlatformClient  {

    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = GamesApiDataSource::class.java,
        authInterceptor = GameApiInterceptor()
    )

    suspend fun listPlatforms(): PlatformResponse? {
        return client.listPlatforms().body()
    }

    suspend fun detailPlatform(id: Int): ApiPlatform? {
        return client.detailPlatform(id).body()
    }

    suspend fun listGames(): GameResponse? {
        return client.listGames().body()
    }

    suspend fun detailGame(id: Int): ApiGame? {
        return client.detailGame(id).body()
    }
}