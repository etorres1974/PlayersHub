package br.com.playershub.data

import br.com.playershub.data.entity.PlatformResponse
import br.com.playershub.data.clients.GamesPlatformClient

class ApiClient {

    suspend fun listPlatforms(): PlatformResponse? {
        return GamesPlatformClient().listPlatforms().body()
    }

}