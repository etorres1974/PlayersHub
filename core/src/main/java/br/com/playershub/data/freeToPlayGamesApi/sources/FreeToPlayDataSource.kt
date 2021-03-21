package br.com.playershub.data.freeToPlayGamesApi.sources

import br.com.playershub.data.freeToPlayGamesApi.entity.ApiFreeToPlayGame
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToPlayDataSource {
    @GET("games")
    suspend fun listGames(): Response<List<ApiFreeToPlayGame>>

    @GET("game")
    suspend fun detailGame(@Query("id") id: Int): Response<ApiFreeToPlayGame>
}