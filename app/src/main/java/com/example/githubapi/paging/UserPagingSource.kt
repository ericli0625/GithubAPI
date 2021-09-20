package com.example.githubapi.paging

import android.util.Log
import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.base.model.UserInfo
import com.example.base.model.UserItem
import com.example.base.network.api.NetworkApi
import io.reactivex.Single

class UserPagingSource(
        private val networkApi: NetworkApi,
        private val query: String,
        private val perPage: Int,
        private val onShowErrorMessageListener: (Int) -> Unit,
        private val onShowThrowableMessageListener: (Throwable) -> Unit
) : RxPagingSource<Int, UserItem>() {

    override fun getRefreshKey(state: PagingState<Int, UserItem>): Int? {
        return state.anchorPosition
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, UserItem>> {
        val position = params.key ?: 1

        return networkApi.getUsers(query = query, perPage = perPage, page = position)
                .map {
                    if (!it.isSuccessful) onShowErrorMessageListener(it.code())
                    it.body()
                }
                .map {
                    Log.e("eric", " UserPagingSource, loadSingle position = $position")
                    toLoadResult(it, position)
                }
                .onErrorReturn {
                    onShowThrowableMessageListener(it)
                    LoadResult.Error(it)
                }
    }

    private fun toLoadResult(data: UserInfo, position: Int): LoadResult<Int, UserItem> {
        return LoadResult.Page(
                data = data.items,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == data.totalCount) null else position + 1
        )
    }
}