package br.com.playershub.data.rawgGamesApi.clients


import br.com.playershub.data.rawgGamesApi.sources.PagedResponse
import br.com.playershub.data.rawgGamesApi.entity.Ordering
import br.com.playershub.data.rawgGamesApi.entity.games.ApiGameDetails
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import br.com.playershub.domain.entity.Game
import retrofit2.Response
import java.time.LocalDate

class RawgGamesClient {
    private val client = ApiUtilsProvider.retrofit(
        apiBaseUrl = VIDEO_GAME_DB_URL,
        apiServiceInterface = RawgGamesApiDataSource::class.java,
        authInterceptor = RawgGamesApiInterceptor()
    )

    suspend fun listPagedGames(page: Int, size: Int): Response<PagedResponse<Game>> {
        return client.listPagedGames(page, size) as Response<PagedResponse<Game>>
    }

    suspend fun listGamesUpcoming(page: Int, size: Int): Response<PagedResponse<Game>> {
        val today = LocalDate.now()
        val nextYear = LocalDate.now().plusYears(1)
        val dates = formatDateRange(today, nextYear)
        val ordering = Ordering.I_ADDED
        return client.listGamesByDateRange(
            page,
            size,
            dates,
            ordering
        ) as Response<PagedResponse<Game>>
    }

    suspend fun listGamesTrending(page: Int, size: Int): Response<PagedResponse<Game>> {
        val today = LocalDate.now()
        val lastSemester = today.plusMonths(-3)
        val dates = formatDateRange(lastSemester, today)
        val ordering = Ordering.RATING
        return client.listGamesByDateRange(
            page,
            size,
            dates,
            ordering
        ) as Response<PagedResponse<Game>>
    }

    suspend fun detailGame(id: Int): Response<ApiGameDetails> {
        return client.detailGame(id)
    }

    private fun formatDateRange(from: LocalDate, to: LocalDate) = "$from,$to"
}