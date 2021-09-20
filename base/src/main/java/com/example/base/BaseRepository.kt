package com.example.base

import com.example.base.network.api.NetworkApi
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepository : KoinComponent {
    protected val networkApi: NetworkApi by inject()
}