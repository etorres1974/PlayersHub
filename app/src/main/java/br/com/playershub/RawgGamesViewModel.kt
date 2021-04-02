package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.components.GamesViewModel
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.entity.GameDetails
import br.com.playershub.domain.interactors.GetGames
import br.com.util.BaseViewModel

class RawgGamesViewModel(
    private val getGames: GetGames = GetGames()
) : BaseViewModel(), GamesViewModel {

    override val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }

    override val openDetails: LiveData<Int> get() = _openDetails
    private val _openDetails by lazy { MutableLiveData<Int>() }

    val gameDetails: LiveData<GameDetails> get() = _gameDetails
    private val _gameDetails by lazy { MutableLiveData<GameDetails>() }

    init {
        launchDataLoad {
            _games.value = getGames.list()
        }
    }

    override fun fetchGamesDetail(id: Int) {
        val action = FirstFragmentDirections.actionToDetailsFragment(id)
        getGame(id)
        setNewDestination(action)
    }

    fun getGame(id: Int) {
        launchDataLoad {
            _gameDetails.value = getGames.byId(id)
        }
    }

}