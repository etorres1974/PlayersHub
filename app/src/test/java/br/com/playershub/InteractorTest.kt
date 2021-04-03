package br.com.playershub


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.playershub.domain.interactors.GetGames
import br.com.playershub.rules.TestCoroutineDispatcherRule
import br.com.util.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import kotlin.system.measureTimeMillis

class InteractorTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = TestCoroutineDispatcherRule()

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @Test
    fun testGamesList() = runBlocking {
        val getGames = GetGames()
        val time = measureTimeMillis {
            val gameList = getGames.list().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay : $time")
    }

    @Test
    fun testGamesUpcoming() = runBlocking {
        val getGames = GetGames()
        val time = measureTimeMillis {
            val gameList = getGames.upcoming().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay  : $time")
    }

    @Test
    fun testGamesTrending() = runBlocking {
        val getGames = GetGames()
        val time = measureTimeMillis {
            val gameList = getGames.trending().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay : $time")
    }

}