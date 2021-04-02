package br.com.playershub

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import br.com.components.GamesViewModel
import br.com.playershub.data.MockVideoGameRepository
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.interactors.GetGames
import br.com.util.BaseViewModel

class RawgGamesViewModel(
    private val getGames: GetGames = GetGames(),
    private val mock: MockVideoGameRepository = MockVideoGameRepository()
) : BaseViewModel(), GamesViewModel {

    override val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }

    override val openDetails: LiveData<Int> get() = _openDetails
    private val _openDetails by lazy { MutableLiveData<Int>() }

    init {
        launchDataLoad {
            _games.value = getGames.list()
        }
    }

    override fun fetchGamesDetail(id: Int) {
        Log.d("Test", "id : $id")
        val action = FirstFragmentDirections.actionToDetailsFragment(id)
        setNewDestination(action)
    }

}