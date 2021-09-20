package com.example.githubapi.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.base.BaseActivity
import com.example.base.extension.hide
import com.example.base.extension.showOrHide
import com.example.githubapi.R
import com.example.githubapi.databinding.ActivityMainBinding
import com.example.githubapi.util.PagingLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel: MainViewModel by viewModel()

    private val userAdapter by lazy { UserAdapter(::onCardClickedListener) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun subscribeObservers() {
        super.subscribeObservers()
        subscribeToGetUsers()
    }

    private fun initView() {
        with(binding) {
            with(userAdapter) {
                recyclerView.adapter = withLoadStateHeaderAndFooter(
                        header = PagingLoadStateAdapter(this),
                        footer = PagingLoadStateAdapter(this)
                )
            }

            recyclerView.apply {
                addItemDecoration(
                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                            ContextCompat.getDrawable(context, R.drawable.line_divider_middle)
                                    ?.let(::setDrawable)
                        }
                )
            }

            editTextKeyword.setOnEditorActionListener { _, actionId, _ ->
                return@setOnEditorActionListener when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        performSearch(editTextKeyword.text.toString())
                        true
                    }
                    else -> false
                }
            }

            inputText.setEndIconOnClickListener {
                editTextKeyword.setText("")
            }
        }
    }

    private fun performSearch(query: String) {
        viewModel.getUsers(query)
    }

    private fun onCardClickedListener(url: String) {
        Intent().apply {
            action = Intent.ACTION_VIEW
            addCategory(Intent.CATEGORY_BROWSABLE)
            data = Uri.parse(url)
        }.let(::startActivity)
    }

    /***** Subscribe methods implementation *****/

    private fun subscribeToGetUsers() {
        viewModel.getUsers.observe(this) {
            userAdapter.submitData(lifecycle, it)
            binding.imageEmpty.hide()
        }
    }
}