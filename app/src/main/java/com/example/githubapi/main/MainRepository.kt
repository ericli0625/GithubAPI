package com.example.githubapi.main

import com.example.base.BaseRepository
import com.example.base.model.UserInfo
import io.reactivex.Observable
import retrofit2.Response

class MainRepository : BaseRepository() {

    fun getUsers(
            query: String = "",
            sort: String = "",
            order: String = "desc",
            perPage: Int = 30,
            page: Int = 1
    ): Observable<Response<UserInfo>> {
        return networkApi.getUsers(query, sort, order, perPage, page)
    }
}