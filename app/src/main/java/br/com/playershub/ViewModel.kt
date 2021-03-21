package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playershub.data.MockVideoGameRepository
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.interactors.GetFreeGames
import br.com.playershub.domain.interactors.GetGames
import kotlinx.coroutines.launch

class ViewModel(
    private val getGames: GetGames = GetGames(),
    private val getFreeGames: GetFreeGames = GetFreeGames(),
    private val mock: MockVideoGameRepository = MockVideoGameRepository()
) : ViewModel() {

    val games: LiveData<List<Game>> get() = _games
    private val _games: MutableLiveData<List<Game>> by lazy { MutableLiveData<List<Game>>() }

    fun listRawgGames(){
        viewModelScope.launch {
            _games.value = getGames.list()
        }
    }

    fun listFreeGames() {
        viewModelScope.launch {
            _games.value = getFreeGames.list()
        }
    }
}