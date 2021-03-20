package br.com.playershub.data.RAWGVideoGame.sources

import br.com.playershub.data.RAWGVideoGame.entity.ApiPlatform
import br.com.playershub.data.RAWGVideoGame.entity.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApiDataSource {
    @GET("platforms")
    suspend fun listPlatforms(): Response<PlatformResponse>

    @GET("platforms")
    suspend fun detailPlatform(@Query("id") id: Int): Response<ApiPlatform>
}