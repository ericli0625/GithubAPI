package com.example.githubapi.koin

import com.example.base.network.api.NetworkApi
import com.example.githubapi.main.MainRepository
import com.example.githubapi.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {

    single { NetworkApi.sharedInstance() }

    // activity
    factory { MainRepository() }
}

val viewModule: Module = module {
    // activity
    viewModel { MainViewModel(get()) }
}

val appModule = listOf(repositoryModule, viewModule)