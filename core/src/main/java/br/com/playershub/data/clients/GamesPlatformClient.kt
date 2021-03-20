package br.com.playershub.data.clients

import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import br.com.playershub.data.entity.PlatformResponse
import br.com.playershub.data.sources.PlatformDataSource
import retrofit2.Response

class GamesPlatformClient : PlatformDataSource {
    private val client = ApiUtilsProvider.retrofit(VIDEO_GAME_DB_URL, PlatformDataSource::class.java)

    override suspend fun listPlatforms(): Response<PlatformResponse> {
        return  client.listPlatforms()
    }
}