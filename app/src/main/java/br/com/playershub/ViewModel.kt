package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playershub.domain.interactors.GetGames
import kotlinx.coroutines.launch

class ViewModel(
    private val getGames: GetGames = GetGames()
) : ViewModel() {

    val platform: LiveData<Any> get() = _platforms
    private val _platforms: MutableLiveData<Any> by lazy { MutableLiveData<Any>() }

    fun listPlatforms() {
        viewModelScope.launch {
            _platforms.value = getGames.list()
        }
    }
}