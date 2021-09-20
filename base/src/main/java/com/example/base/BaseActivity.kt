package com.example.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<B : ViewBinding, V : BaseViewModel> : AppCompatActivity() {

    protected abstract val binding: B
    protected abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribeObservers()
    }

    @CallSuper
    protected open fun subscribeObservers() {
        subscribeToShowErrorSnackBar()
    }

    private fun showNetworkError() {
        Snackbar.make(
                findViewById(android.R.id.content),
                R.string.type_error_common,
                Snackbar.LENGTH_LONG
        )
                .setAction("OK") {}
                .show()
    }

    /***** Subscribe methods implementation *****/

    private fun subscribeToShowErrorSnackBar() {
        viewModel.showErrorSnackBar.observe(this) {
            showNetworkError()
        }
    }
}