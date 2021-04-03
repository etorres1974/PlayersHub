package br.com.playershub.mockito


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

class RepositoryMockTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = TestCoroutineDispatcherRule()

    @MockK
    lateinit var repository: GamesBoundary
    lateinit var getGames: GetGames

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        this.getGames = GetGames(repository)
        setupMocks()
    }

    @After
    fun teardown() {

    }

    @Test
    fun getGames() = runBlocking {
        val games = getGames.list()
        assertThat(games.isNullOrEmpty()).isFalse()
    }

    private fun setupMocks() {
        coEvery { repository.listGames() } returns listOf(
            mockk {
                every { id } returns 1
                every { name } returns "League of legends"
                every { image } returns "fake_image_url"
            }
        )
    }
}