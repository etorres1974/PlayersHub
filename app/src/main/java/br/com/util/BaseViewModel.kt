package br.com.util

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(), LifecycleObserver{

    val loading : LiveData<Boolean> get() = _loading
    private val _loading by lazy { MutableLiveData<Boolean>() }

    val newDestination: LiveData<NavDirections> get() = _newDestination
    private val _newDestination by lazy { MutableLiveData<NavDirections>() }

    fun setNewDestination(navDirections: NavDirections) {
        _newDestination.value = navDirections
    }

    fun showLoading(boolean: Boolean) {
        _loading.value = boolean
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

    private fun defaultOnFailure(throwable: Throwable) {
        Log.d("Request Fail", throwable.toString())
    }
}