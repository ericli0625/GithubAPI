package com.example.base.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @SerializedName("items") val items: List<UserItem>,
        @SerializedName("message") val message: String,
        @SerializedName("errors") val errors: List<ErrorItem>,
        @SerializedName("documentation_url") val docUrl: String
)