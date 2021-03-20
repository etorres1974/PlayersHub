package br.com.playershub.data

import br.com.playershub.data.entity.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET

interface GamesApiService {

    @GET("platforms")
    suspend fun listPlatforms() : Response<PlatformResponse>
}