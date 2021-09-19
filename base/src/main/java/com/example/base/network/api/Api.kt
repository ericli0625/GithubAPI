package com.example.base.network.api

import com.example.base.model.UserInfo
import io.reactivex.Observable
import retrofit2.Response

interface Api {

    fun getUsers(
            query: String,
            sort: String,
            order: String,
            perPage: Int,
            page: Int
    ): Observable<Response<UserInfo>>
}