package com.example.base.network.api

import com.example.base.model.UserInfo
import io.reactivex.Single
import retrofit2.Response

interface Api {

    fun getUsers(
            query: String = "",
            perPage: Int = 30,
            page: Int = 1
    ): Single<Response<UserInfo>>
}