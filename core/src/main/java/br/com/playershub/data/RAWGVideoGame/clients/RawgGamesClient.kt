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

class RawgGamesClient : GamesApiDataSource  {

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

    override suspend fun listGames(): Response<GameResponse> {
        return client.listGames()
    }

    override suspend fun detailGame(id: Int): Response<ApiGame> {
        return client.detailGame(id)
    }
}