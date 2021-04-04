package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import br.com.components.GamesViewModel
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails
import br.com.playershub.domain.interactors.*
import br.com.util.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RawgGamesViewModel @Inject constructor(
    private val getGames: GetGames,
    private val getPagedAllGames: GetPagedAllGames,
    private val getPagedUpcomingGames: GetPagedUpcomingGames,
    private val getPagedTrendingGames: GetPagedTrendingGames
) : BaseViewModel(), GamesViewModel {

    lateinit var pagedGames: LiveData<PagedList<Game>>
    lateinit var pagedUpcomingGames: LiveData<PagedList<Game>>
    lateinit var pagedTrendingGames: LiveData<PagedList<Game>>

    override val openDetails: LiveData<Int> get() = _openDetails
    private val _openDetails by lazy { MutableLiveData<Int>() }

    val gameDetails: LiveData<GameDetails> get() = _gameDetails
    private val _gameDetails by lazy { MutableLiveData<GameDetails>() }

    init {
        init()
    }

    fun init() {
        pagedGames = getPagedLiveData(getPagedAllGames.invoke())
        pagedUpcomingGames = getPagedLiveData(getPagedUpcomingGames.invoke())
        pagedTrendingGames = getPagedLiveData(getPagedTrendingGames.invoke())
    }

    override fun fetchGamesDetail(id: Int) {
        val action = FirstFragmentDirections.actionToDetailsFragment(id)
        getGame(id)
        setNewDestination(action)
    }

    private fun getGame(id: Int) {
        launchDataLoad {
            _gameDetails.value = getGames.byId(id)
        }
    }

}