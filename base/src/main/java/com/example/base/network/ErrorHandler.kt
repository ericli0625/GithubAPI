package com.example.base.network

import java.io.IOException
import java.net.SocketTimeoutException

object ErrorHandler {

    fun handle(code: Int) {
        when (code) {
            StatusCode.TYPE_NOT_MODIFIED -> {
                "沒有任何改變"
            }
            StatusCode.TYPE_SERVICE_UNAVAILABLE -> {
                "服務暫停"
            }
            StatusCode.TYPE_VALIDATION_FAILED -> {
                "驗證失敗"
            }
        }
    }

    fun handle(t: Throwable) {
        when (t) {
            is SocketTimeoutException -> {
                "網路連線逾時"
            }
            is IOException -> {
                "網路連線失敗，請檢查網路"
            }
            else -> {
                "伺服器問題，請稍後再試"
            }
        }
    }
}