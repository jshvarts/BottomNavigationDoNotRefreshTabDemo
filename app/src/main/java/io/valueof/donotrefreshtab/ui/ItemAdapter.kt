package io.valueof.donotrefreshtab.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.valueof.donotrefreshtab.R
import io.valueof.donotrefreshtab.databinding.ItemCardBinding
import io.valueof.donotrefreshtab.model.Item

class ItemAdapter : ListAdapter<Item, ItemViewHolder>(ItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ItemViewHolder(
    private val binding: ItemCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.title.text = item.title
        binding.description.text = item.description
        binding.image.load(R.drawable.bldg) {
            crossfade(true)
        }
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
