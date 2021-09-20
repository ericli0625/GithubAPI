package com.example.githubapi.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.extension.showTextIfNotBlank
import com.example.base.model.UserItem
import com.example.githubapi.databinding.ComponentUserItemBinding

class UserAdapter(
        private val onCardClickedListener: (String) -> Unit,
        private var items: List<UserItem> = listOf()
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                    ComponentUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                    onCardClickedListener
            )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(items[position])

    fun updateData(items: List<UserItem>) {
        this.items = items
        notifyDataSetChanged()
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
}