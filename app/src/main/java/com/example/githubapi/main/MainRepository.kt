package com.example.githubapi.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.observable
import com.example.base.BaseRepository
import com.example.base.model.UserItem
import com.example.githubapi.paging.UserPagingSource
import io.reactivex.Observable

class MainRepository : BaseRepository() {

    fun getUsers(
            query: String,
            onShowErrorMessageListener: (Int) -> Unit,
            onShowThrowableMessageListener: (Throwable) -> Unit,
            perPage: Int = 30
    ): Observable<PagingData<UserItem>> {
        return Pager(
                config = PagingConfig(
                        pageSize = perPage,
                        enablePlaceholders = true,
                        prefetchDistance = 10
                ),
                pagingSourceFactory = {
                    UserPagingSource(
                            networkApi,
                            query,
                            perPage,
                            onShowErrorMessageListener,
                            onShowThrowableMessageListener
                    )
                }
        ).observable
    }
}