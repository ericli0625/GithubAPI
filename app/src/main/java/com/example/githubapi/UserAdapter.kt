package com.example.githubapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.extension.showTextIfNotBlank
import com.example.base.model.UserItem
import com.example.githubapi.databinding.ComponentUserItemBinding

class UserAdapter(
        private var items: List<UserItem> = listOf(),
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ComponentUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(items[position])

    fun updateData(items: List<UserItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(
            private val binding: ComponentUserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserItem) {
            with(binding) {
                imagePhoto.setImageURI(item.avatarUrl)
                textTitle.showTextIfNotBlank(item.login)
            }
        }
    }
}