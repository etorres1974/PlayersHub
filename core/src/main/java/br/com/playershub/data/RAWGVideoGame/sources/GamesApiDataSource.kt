package br.com.playershub.data.RAWGVideoGame.sources

import br.com.playershub.data.RAWGVideoGame.entity.ApiGame
import br.com.playershub.data.RAWGVideoGame.entity.ApiPlatform
import br.com.playershub.data.RAWGVideoGame.entity.GameResponse
import br.com.playershub.data.RAWGVideoGame.entity.PlatformResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApiDataSource {
    @GET("platforms")
    suspend fun listPlatforms(): Response<PlatformResponse>

    @GET("platforms")
    suspend fun detailPlatform(@Query("id") id: Int): Response<ApiPlatform>

    @GET("games")
    suspend fun listGames(): Response<GameResponse>

    @GET("games")
    suspend fun detailGame(@Query("id") id: Int): Response<ApiGame>

    /* Todo Uncomment and change any to correct entity
    @GET("genres")
    suspend fun listGenres(): Response<Any>

    @GET("genres")
    suspend fun detailGenres(@Query("id") id: Int): Response<Any>

    @GET("publishers")
    suspend fun listPublishers(): Response<Any>

    @GET("publishers")
    suspend fun detailPublisher(@Query("id") id: Int): Response<Any>

    @GET("stores")
    suspend fun listStores(): Response<Any>

    @GET("stores")
    suspend fun detailStore(@Query("id") id: Int): Response<Any>

    @GET("tags")
    suspend fun listTags(): Response<Any>

    @GET("tags")
    suspend fun detailTag(@Query("id") id: Int): Response<Any>

    @GET("developers")
    suspend fun listDevelopers(): Response<Any>

    @GET("developers")
    suspend fun detailDeveloper(@Query("id") id: Int): Response<Any>

    @GET("creators")
    suspend fun listCreators(): Response<Any>

    @GET("creators")
    suspend fun detailCreator(@Query("id") id: Int): Response<Any>

    @GET("creators-roles")
    suspend fun listCreatorRoles(): Response<Any>
    */
}