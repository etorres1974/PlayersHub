package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.playershub.data.MockVideoGameRepository
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.interactors.GetFreeGames
import br.com.playershub.domain.interactors.GetGames

class GamesViewModel(
    private val getGames: GetGames = GetGames(),
    private val getFreeGames: GetFreeGames = GetFreeGames(),
    private val mock: MockVideoGameRepository = MockVideoGameRepository()
) : SharedViewModel() {

    val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }

    fun listRawgGames() {
        launchDataLoad {
            _games.value = emptyList()
            _games.value = getGames.list()
        }
    }

    fun listFreeGames() {
        launchDataLoad {
            _games.value = emptyList()
            _games.value = getFreeGames.list()
        }
    }
}