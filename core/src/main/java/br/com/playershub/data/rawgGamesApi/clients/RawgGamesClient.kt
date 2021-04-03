package br.com.playershub.data.rawgGamesApi.clients


import br.com.playershub.data.rawgGamesApi.entity.Ordering
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGameDetails
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGamesResponse
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import retrofit2.Response
import java.time.LocalDate

class RawgGamesClient {
    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = RawgGamesApiDataSource::class.java,
        authInterceptor = RawgGamesApiInterceptor()
    )

    suspend fun listGames(): Response<ApiGamesResponse> {
        return client.listGames()
    }

    suspend fun listGamesUpcoming(): Response<ApiGamesResponse> {
        val today = LocalDate.now()
        val nextYear = LocalDate.now().plusYears(1)
        val dates = formatDateRange(today, nextYear)
        val ordering = Ordering.I_ADDED
        return client.listGamesByDateRange(dates, ordering)
    }

    suspend fun listGamesTrending(): Response<ApiGamesResponse> {
        val today = LocalDate.now()
        val lastSemester = today.plusMonths(-3)
        val dates = formatDateRange(lastSemester, today)
        val ordering = Ordering.RATING
        return client.listGamesByDateRange(dates, ordering)
    }

    suspend fun detailGame(id: Int): Response<ApiGameDetails> {
        return client.detailGame(id)
    }

    private fun formatDateRange(from : LocalDate, to : LocalDate) =  "$from,$to"
}