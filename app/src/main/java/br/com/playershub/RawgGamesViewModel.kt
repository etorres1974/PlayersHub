package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import br.com.components.GamesViewModel
import br.com.playershub.data.rawgGamesApi.GamesPagedDataSource
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails
import br.com.playershub.domain.interactors.GetGames
import br.com.playershub.domain.interactors.PagedDataSourceFactory
import br.com.util.BaseViewModel

class RawgGamesViewModel(
    private val getGames: GetGames = GetGames()
) : BaseViewModel(), GamesViewModel {

    lateinit var pagedGames : LiveData<PagedList<Game>>

    override val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }

    override val gamesUpcoming: LiveData<List<Game>> get() = _gamesUpcoming
    private val _gamesUpcoming by lazy { MutableLiveData<List<Game>>() }

    override val gamesTrending: LiveData<List<Game>> get() = _gamesTrending
    private val _gamesTrending by lazy { MutableLiveData<List<Game>>() }

    override val openDetails: LiveData<Int> get() = _openDetails
    private val _openDetails by lazy { MutableLiveData<Int>() }

    val gameDetails: LiveData<GameDetails> get() = _gameDetails
    private val _gameDetails by lazy { MutableLiveData<GameDetails>() }

    init {
        init()
    }

    fun init() {
        pagedGames = LivePagedListBuilder(PagedDataSourceFactory, configPagination()).build()
        launchDataLoad {
            //_games.value = getGames.list()
            //_gamesUpcoming.value = getGames.upcoming()
            //_gamesTrending.value = getGames.trending()
        }
    }
    private fun configPagination() = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(true)
            .build()


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