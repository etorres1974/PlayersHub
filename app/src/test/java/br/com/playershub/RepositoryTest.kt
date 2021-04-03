package br.com.playershub


import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RepositoryTest : BaseTest() {

    @Test
    fun testListGames() = runBlocking {
        val repository = RawgVideoGameRepository()
        val gameList = repository.listGames().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }

    @Test
    fun testUpcomingGames() = runBlocking {
        val repository = RawgVideoGameRepository()
        val gameList = repository.listGamesUpcoming().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }

    @Test
    fun testTrendingGames() = runBlocking {
        val repository = RawgVideoGameRepository()
        val gameList = repository.listGamesTrending().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }
}