package com.example.githubapi

import android.os.Bundle
import com.example.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val layoutRes: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUsers()
    }

    override fun subscribeObservers() {
        super.subscribeObservers()
        subscribeToGetUsers()
    }

    /***** Subscribe methods implementation *****/

    private fun subscribeToGetUsers() {
        viewModel.getUsers.observe(this) {

        }
    }
}