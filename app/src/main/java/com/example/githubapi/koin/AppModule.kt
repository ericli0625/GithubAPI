package com.example.githubapi.koin

import com.example.githubapi.MainRepository
import com.example.githubapi.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    // activity
    factory { MainRepository() }
}

val viewModule: Module = module {
    // activity
    viewModel { MainViewModel(get()) }
}

val appModule = listOf(repositoryModule, viewModule)