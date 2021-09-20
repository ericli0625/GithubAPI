package com.example.base.network.api

import com.example.base.model.UserInfo
import com.example.base.network.Config.BASE_API_URL
import com.example.base.network.retrofit.RetrofitClient
import com.example.base.network.service.GithubService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi : Api {

    private val getHubService: GithubService by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .client(RetrofitClient.getClient())
                .build()
                .create(GithubService::class.java)
    }

    override fun getUsers(
            query: String,
            perPage: Int,
            page: Int
    ): Single<Response<UserInfo>> {
        return getHubService.getUsers(query, perPage, page)
    }
}