package br.com.playershub.data

import br.com.playershub.data.RAWGVideoGame.clients.GamesPlatformClient
import br.com.playershub.data.RAWGVideoGame.entity.ApiPlatform
import br.com.playershub.data.RAWGVideoGame.entity.PlatformResponse

class ApiClient {
    val gamesPlatformClient = GamesPlatformClient()

    suspend fun listPlatforms(): PlatformResponse? {
        return gamesPlatformClient.listPlatforms().body()
    }

    suspend fun detailPlatform(id: Int): ApiPlatform? {
        return gamesPlatformClient.detailPlatform(id).body()
    }

}