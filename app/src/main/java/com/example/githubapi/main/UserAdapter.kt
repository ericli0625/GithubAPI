package com.example.githubapi.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.base.extension.showTextIfNotBlank
import com.example.base.model.UserItem
import com.example.githubapi.databinding.ComponentUserItemBinding

class UserAdapter(
        private val onCardClickedListener: (String) -> Unit
) : PagingDataAdapter<UserItem, UserAdapter.ViewHolder>(UserItemsComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                    ComponentUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                    onCardClickedListener
            )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class ViewHolder(
            private val binding: ComponentUserItemBinding,
            private val onCardClickedListener: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserItem) {
            with(binding) {
                imagePhoto.setImageURI(item.avatarUrl)
                textTitle.showTextIfNotBlank(item.login)
                layoutCard.setOnClickListener {
                    onCardClickedListener(item.htmlUrl)
                }
            }
        }
    }

    object UserItemsComparator : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem == newItem
        }
    }
}