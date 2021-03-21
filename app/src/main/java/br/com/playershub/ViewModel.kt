package br.com.playershub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playershub.data.RAWGVideoGame.clients.GamesPlatformClient
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    val platform: LiveData<Any> get() = _platforms
    private val _platforms: MutableLiveData<Any> by lazy { MutableLiveData<Any>() }

    fun listPlatforms() {
        viewModelScope.launch {
            _platforms.value = GamesPlatformClient().listGames()
        }
    }
}