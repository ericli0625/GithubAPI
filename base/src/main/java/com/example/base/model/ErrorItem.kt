package com.example.base.model

import com.google.gson.annotations.SerializedName

data class ErrorItem(
        @SerializedName("resource") val resource: String,
        @SerializedName("field") val field: String,
        @SerializedName("code") val code: String
)