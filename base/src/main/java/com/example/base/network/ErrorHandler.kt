package com.example.base.network

import androidx.annotation.IntegerRes
import com.example.base.R
import java.io.IOException
import java.net.SocketTimeoutException

object ErrorHandler {

    @IntegerRes
    fun handle(code: Int): Int {
        return when (code) {
            StatusCode.TYPE_NOT_MODIFIED -> R.string.type_error_not_modified
            StatusCode.TYPE_SERVICE_UNAVAILABLE -> R.string.type_error_service_unavailable
            StatusCode.TYPE_VALIDATION_FAILED -> R.string.type_error_validation_failed
            else -> R.string.type_error_common
        }
    }

    @IntegerRes
    fun handle(t: Throwable): Int {
        return when (t) {
            is SocketTimeoutException -> R.string.type_error_socket_timeout_exception
            is IOException -> R.string.type_error_io_exception
            else -> R.string.type_error_common
        }
    }
}