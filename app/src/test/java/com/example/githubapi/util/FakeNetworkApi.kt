package com.example.githubapi.util

import com.example.base.model.UserInfo
import com.example.base.model.UserItem
import com.example.base.network.api.Api
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import retrofit2.Response
import java.lang.reflect.Type

class FakeNetworkApi : Api {

    private val jsonString = "{\n" +
            "            \"login\": \"app\",\n" +
            "            \"id\": 9341,\n" +
            "            \"node_id\": \"MDQ6VXNlcjkzNDE=\",\n" +
            "            \"avatar_url\": \"https://avatars.githubusercontent.com/u/9341?v=4\",\n" +
            "            \"gravatar_id\": \"\",\n" +
            "            \"url\": \"https://api.github.com/users/app\",\n" +
            "            \"html_url\": \"https://github.com/app\",\n" +
            "            \"followers_url\": \"https://api.github.com/users/app/followers\",\n" +
            "            \"following_url\": \"https://api.github.com/users/app/following{/other_user}\",\n" +
            "            \"gists_url\": \"https://api.github.com/users/app/gists{/gist_id}\",\n" +
            "            \"starred_url\": \"https://api.github.com/users/app/starred{/owner}{/repo}\",\n" +
            "            \"subscriptions_url\": \"https://api.github.com/users/app/subscriptions\",\n" +
            "            \"organizations_url\": \"https://api.github.com/users/app/orgs\",\n" +
            "            \"repos_url\": \"https://api.github.com/users/app/repos\",\n" +
            "            \"events_url\": \"https://api.github.com/users/app/events{/privacy}\",\n" +
            "            \"received_events_url\": \"https://api.github.com/users/app/received_events\",\n" +
            "            \"type\": \"User\",\n" +
            "            \"site_admin\": false,\n" +
            "            \"score\": 1.0\n" +
            "        }"

    fun getUserItem(): UserItem {
        val type = object : TypeToken<UserItem>() {}.type
        return Gson().fromJsonOrElse(jsonString, type) { UserItem.defaultInstance }
    }

    override fun getUsers(query: String, perPage: Int, page: Int): Single<Response<UserInfo>> {
        val userInfo = UserInfo(
                86891,
                false,
                listOf(
                        getUserItem()
                ),
                "",
                listOf(),
                ""
        )
        return Single.just(Response.success(userInfo))
    }

    fun <T> Gson.fromJsonOrElse(json: String, typeOfT: Type, defaultValue: () -> T): T =
            try {
                fromJson(json, typeOfT)
            } catch (e: JsonSyntaxException) {
                defaultValue()
            } catch (e: JsonParseException) {
                defaultValue()
            }
}