package com.example.githubapi.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.example.base.BaseViewModel
import com.example.base.model.UserItem
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: MainRepository) : BaseViewModel(repository) {

    private val _getUsers by lazy { MutableLiveData<PagingData<UserItem>>() }
    val getUsers: LiveData<PagingData<UserItem>> by lazy { _getUsers }

    fun getUsers(query: String) {
        repository.getUsers(
                query,
                { showErrorSnackBar(it) },
                { showErrorSnackBar(it) }
        )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWithAutoDispose { _getUsers.value = it }
    }

}