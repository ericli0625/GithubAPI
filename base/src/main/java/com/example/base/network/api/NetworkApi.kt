package com.example.base.network.api

import com.example.base.model.UserInfo
import io.reactivex.Observable
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
            sort: String,
            order: String,
            perPage: Int,
            page: Int
    ): Observable<Response<UserInfo>> {
        return api.getUsers(query, sort, order, perPage, page)
    }

}