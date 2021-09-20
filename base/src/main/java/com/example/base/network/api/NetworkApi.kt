package com.example.base.network.api

import com.example.base.model.UserInfo
import io.reactivex.Single
import retrofit2.Response

class NetworkApi(private val api: Api) : Api {

    companion object {
        private val instance = NetworkApi(RetrofitApi())

        @JvmStatic
        fun sharedInstance(): NetworkApi {
            return instance
        }
    }

    override fun getUsers(
            query: String,
            perPage: Int,
            page: Int
    ): Single<Response<UserInfo>> {
        return api.getUsers(query, perPage, page)
    }

}