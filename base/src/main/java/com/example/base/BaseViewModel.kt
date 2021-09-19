package com.example.base

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(private val repository: BaseRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

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
}