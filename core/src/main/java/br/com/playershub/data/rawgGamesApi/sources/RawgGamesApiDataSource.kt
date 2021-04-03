package br.com.playershub.data.rawgGamesApi.sources

import br.com.playershub.data.rawgGamesApi.entity.*
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGameDetails
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGamesResponse
import br.com.playershub.data.rawgGamesApi.entity.games.Platform
import br.com.playershub.data.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgGamesApiDataSource {
    @GET("platforms")
    suspend fun listPlatforms(): Response<Platform>

    @GET("platforms")
    suspend fun detailPlatform(@Query("id") id: Int): Response<Platform>

    @GET("games")
    suspend fun listGames(): Response<ApiGamesResponse>

    @GET("games")
    suspend fun listPagedGames(
        @Query("page") page: Int,
        @Query("page_size") size : Int
    ): Response<ApiGamesResponse>

    @GET("games")
    suspend fun listGamesByDateRange(
        @Query("dates") dateRange: String,
        @Query("ordering") ordering : Ordering,
    ): Response<ApiGamesResponse>

    @GET("games/{id}")
    suspend fun detailGame(
        @Path("id") id: Int,
    ): Response<ApiGameDetails>

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