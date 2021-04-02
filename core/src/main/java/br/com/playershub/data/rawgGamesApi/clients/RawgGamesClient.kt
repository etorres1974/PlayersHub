package br.com.playershub.data.rawgGamesApi.clients

import br.com.playershub.data.rawgGamesApi.entity.ApiPlatform
import br.com.playershub.data.rawgGamesApi.entity.ApiRawgGameDetails
import br.com.playershub.data.rawgGamesApi.entity.GameResponse
import br.com.playershub.data.rawgGamesApi.entity.PlatformResponse
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import com.google.gson.internal.bind.util.ISO8601Utils.format
import retrofit2.Response
import java.lang.String.format
import java.text.DateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class RawgGamesClient {
    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = RawgGamesApiDataSource::class.java,
        authInterceptor = RawgGamesApiInterceptor()
    )

    suspend fun listPlatforms(): Response<PlatformResponse> {
        return client.listPlatforms()
    }

    suspend fun detailPlatform(id: Int): Response<ApiPlatform> {
        return client.detailPlatform(id)
    }

    suspend fun listGames(): Response<GameResponse> {
        return client.listGames()
    }

    suspend fun listGamesUpcoming(): Response<GameResponse> {
        val today = LocalDate.now()
        val nextYear = LocalDate.now().plusYears(1)
        val dates = "$today,$nextYear"
        val ordering = "-added"
        return client.listGamesUpcoming(dates, ordering)
    }

    suspend fun detailGame(id: Int): Response<ApiRawgGameDetails> {
        return client.detailGame(id)
    }
}