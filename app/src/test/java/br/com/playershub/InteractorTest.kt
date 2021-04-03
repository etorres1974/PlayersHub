package br.com.playershub


import br.com.playershub.domain.interactors.GetGames
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class InteractorTest : BaseTest() {

    @Test
    fun testGamesList() = runBlocking {
        val getGames = GetGames()
        val gameList = getGames.list().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }

    @Test
    fun testGamesUpcoming() = runBlocking {
        val getGames = GetGames()
        val gameList = getGames.upcoming().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }

    @Test
    fun testGamesTrending() = runBlocking {
        val getGames = GetGames()
        val gameList = getGames.trending().also { println(it) }
        assertThat(gameList).isNotEmpty()
        assertThat(gameList).isNotNull()
    }
}