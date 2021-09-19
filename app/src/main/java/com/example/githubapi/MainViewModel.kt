package com.example.githubapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.base.BaseViewModel
import com.example.base.model.UserInfo
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: MainRepository) : BaseViewModel(repository) {

    private val _getUsers by lazy { MutableLiveData<UserInfo>() }
    val getUsers: LiveData<UserInfo> by lazy { _getUsers }

    fun getUsers() {
        repository.getUsers("App")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWithAutoDispose(
                        {
                            if (it.isSuccessful) {
                                _getUsers.value = it.body()
                            } else {
                                showErrorSnackBar(it.code())
                            }
                        },
                        {
                            showErrorSnackBar(it)
                        }
                )
    }

}