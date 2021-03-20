package br.com.playershub.Api

import retrofit2.Response
import retrofit2.http.GET

interface GamesApiService {

    @GET("games")
    suspend fun listPlatforms() : Response<Any>
}