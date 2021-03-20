package br.com.playershub.Api

import br.com.playershub.Api.entity.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET

interface GamesApiService {

    @GET("platforms")
    suspend fun listPlatforms() : Response<PlatformResponse>
}