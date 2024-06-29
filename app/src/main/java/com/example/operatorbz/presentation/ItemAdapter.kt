package com.example.operatorbz.presentation

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.operatorbz.R
import com.example.operatorbz.databinding.RvItemBinding
import com.example.operatorbz.domain.Item

class ItemAdapter (private val onClick: (String) -> Unit) :
    ListAdapter<Item, ItemAdapter.ViewHolder>(DiffUtilItem()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding by viewBinding{ RvItemBinding.bind(itemView) }

        fun bind(item: Item) {
            binding.textView.text = getString(this.binding.root.context, item.name)
            Glide.with(binding.imageView)
                .load(item.icon)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .circleCrop()
                .into(binding.imageView)
            binding.root.setOnClickListener{
                onClick.invoke(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    private class DiffUtilItem: DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}