package com.example.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.base.network.ErrorHandler
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(private val repository: BaseRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _showErrorSnackBar by lazy { MutableLiveData<Int>() }
    val showErrorSnackBar: LiveData<Int> by lazy { _showErrorSnackBar }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    fun <T> Observable<T>.subscribeWithAutoDispose(
            onNext: (T) -> Unit,
            onError: (Throwable) -> Unit = {}
    ) {
        subscribe(onNext, onError).let(disposables::add)
    }

    fun showErrorSnackBar(code: Int) {
        _showErrorSnackBar.value = ErrorHandler.handle(code)
    }

    fun showErrorSnackBar(t: Throwable) {
        _showErrorSnackBar.value = ErrorHandler.handle(t)
    }
}