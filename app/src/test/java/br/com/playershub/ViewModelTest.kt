package br.com.playershub


import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ViewModelTest : BaseTest() {

    @Test
    fun testViewModelInit() = runBlocking {
        val vm = RawgGamesViewModel()
        var counter = 0
        printDelay {
            counter += vm.games.getOrAwaitValue().size
            counter += vm.gamesUpcoming.getOrAwaitValue().size
            counter += vm.gamesTrending.getOrAwaitValue().size
        }
        assertThat(vm.games.value).isNotEmpty()
        assertThat(vm.gamesUpcoming.value).isNotEmpty()
        assertThat(vm.gamesTrending.value).isNotEmpty()
        println("Games requested : $counter")
    }
}