package br.com.playershub


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import br.com.playershub.domain.boundary.GamesBoundary
import br.com.playershub.domain.interactors.GetGames
import br.com.playershub.rules.TestCoroutineDispatcherRule
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.system.measureTimeMillis

class RepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = TestCoroutineDispatcherRule()

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @Test
    fun testListGames() = runBlocking{
        val repository = RawgVideoGameRepository()
        val time = measureTimeMillis {
            val gameList = repository.listGames().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay : $time")
    }

    @Test
    fun testUpcomingGames() = runBlocking{
        val repository = RawgVideoGameRepository()
        val time = measureTimeMillis {
            val gameList = repository.listGamesUpcoming().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay : $time")
    }

    @Test
    fun testTrendingGames() = runBlocking{
        val repository = RawgVideoGameRepository()
        val time = measureTimeMillis {
            val gameList = repository.listGamesTrending().also { println(it) }
            assertThat(gameList).isNotEmpty()
            assertThat(gameList).isNotNull()
        }
        println("Request delay : $time")
    }
}