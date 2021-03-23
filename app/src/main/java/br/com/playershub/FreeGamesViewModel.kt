package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.playershub.data.MockVideoGameRepository
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.interactors.GetFreeGames
import br.com.playershub.domain.interactors.GetGames
import android.util.Log
import br.com.components.GamesViewModel
import br.com.playershub.domain.entity.GameDetails

class FreeGamesViewModel(
    private val getFreeGames: GetFreeGames = GetFreeGames(),
    private val mock: MockVideoGameRepository = MockVideoGameRepository()
) : SharedViewModel(), GamesViewModel{

    override val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }

    val openDetails: LiveData<Int> get() = _openDetails
    private val _openDetails by lazy { MutableLiveData<Int>() }

    init {
        launchDataLoad {
            _games.value = getFreeGames.list()
        }
    }

    override fun fetchGamesDetail(id : Int){
        Log.d("Test", "id : $id")
        _openDetails.value = id
    }
}