package br.com.playershub.data.sources

import br.com.playershub.data.entity.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET

interface PlatformDataSource {

    @GET("platforms")
    suspend fun listPlatforms() : Response<PlatformResponse>
}