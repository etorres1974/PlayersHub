package br.com.playershub.Api

import br.com.playershub.Api.entity.PlatformResponse

class ApiClient {

    suspend fun listPlatforms(): PlatformResponse? {
        return  gamesApi.listPlatforms().body()
    }

    companion object {
        private const val API_BASE_URL = "https://rawg-video-games-database.p.rapidapi.com/"
        private val gamesApi = ApiUtilsProvider.retrofit(API_BASE_URL, GamesApiService::class.java)

    }
}