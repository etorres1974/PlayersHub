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

class ViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = TestCoroutineDispatcherRule()

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @Test
    fun testViewModelInit() = runBlocking {
        val vm = RawgGamesViewModel()
        val time = measureTimeMillis {
            vm.games.getOrAwaitValue().also { println(it) }
            vm.gamesUpcoming.getOrAwaitValue().also { println(it) }
            vm.gamesTrending.getOrAwaitValue().also { println(it) }
        }
        assertThat(vm.games.value).isNotEmpty()
        assertThat(vm.gamesUpcoming.value).isNotEmpty()
        assertThat(vm.gamesTrending.value).isNotEmpty()
        println("cost in milliseconds  : $time")
    }


}