package com.example.githubapi

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.base.BaseActivity
import com.example.githubapi.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel: MainViewModel by viewModel()

    private val userAdapter by lazy { UserAdapter() }

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
            recyclerView.apply {
                adapter = userAdapter
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

    /***** Subscribe methods implementation *****/

    private fun subscribeToGetUsers() {
        viewModel.getUsers.observe(this) {
            userAdapter.updateData(it.items)
        }
    }
}