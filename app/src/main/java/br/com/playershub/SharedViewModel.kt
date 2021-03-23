package br.com.playershub

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playershub.domain.entity.GameDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class SharedViewModel : ViewModel(){

    val loading : LiveData<Boolean> get() = _loading
    private val _loading by lazy { MutableLiveData<Boolean>() }

    private fun showLoading(boolean: Boolean) {
        _loading.value = boolean
    }

    private fun defaultOnFailure(throwable: Throwable) {
        Log.d("Request Fail", throwable.toString())
    }

    fun launchDataLoad(
        shouldLoad: Boolean = true,
        onFailure: (Throwable) -> Unit = ::defaultOnFailure,
        block: suspend () -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                showLoading(shouldLoad)
                block()
            } catch (error: Throwable) {
                onFailure(error)
            } finally {
                showLoading(false)
            }
        }
    }
}