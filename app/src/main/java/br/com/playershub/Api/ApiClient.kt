package br.com.playershub.Api

import kotlinx.coroutines.coroutineScope


class ApiClient {

    suspend fun listPlatforms(): Any? {
        return makeRequest { gamesApi.listPlatforms() }
    }

    companion object {
        private const val API_BASE_URL = "https://rawg-video-games-database.p.rapidapi.com/"
        private val gamesApi = ApiUtilsProvider.retrofit(API_BASE_URL, GamesApiService::class.java)

    }

   suspend fun <T> makeRequest(block: suspend () -> retrofit2.Response<T>): T? {
        return coroutineScope {
            try {
                block().run {
                    body()
                }
            } catch (t: Exception) {
                throw t
            }
        }
    }
}