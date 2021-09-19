package com.example.base.network.service

import com.example.base.model.UserInfo
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    fun getUsers(
            @Query("q") query: String = "",
            @Query("sort") sort: String = "",
            @Query("order") order: String = "desc",
            @Query("perPage") perPage: Int = 30,
            @Query("page") page: Int = 1
    ): Observable<Response<UserInfo>>
}