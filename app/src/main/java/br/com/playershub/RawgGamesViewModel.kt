package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.playershub.data.MockVideoGameRepository
import br.com.playershub.domain.entity.Game
import br.com.playershub.domain.interactors.GetFreeGames
import br.com.playershub.domain.interactors.GetGames
import android.util.Log
import br.com.components.GamesViewModel

class RawgGamesViewModel(
    private val getGames: GetGames = GetGames(),
    private val mock: MockVideoGameRepository = MockVideoGameRepository()
) : SharedViewModel(), GamesViewModel{

    override val games: LiveData<List<Game>> get() = _games
    private val _games by lazy { MutableLiveData<List<Game>>() }


    init {
        launchDataLoad {
            _games.value = getGames.list()
        }
    }

    override fun fetchGamesDetail(id : Int){
        Log.d("Test", "id : $id")
    }
}