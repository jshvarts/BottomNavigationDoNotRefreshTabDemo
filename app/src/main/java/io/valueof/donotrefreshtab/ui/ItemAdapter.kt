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

typealias ClickListener = (Item) -> Unit

class ItemAdapter(
    private val clickListener: ClickListener? = null
) : ListAdapter<Item, ItemViewHolder>(ItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ItemViewHolder(
    private val binding: ItemCardBinding,
    private val clickListener: ClickListener?
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: Item

    init {
        binding.card.setOnClickListener {
            clickListener?.invoke(item)
        }
    }

    fun bind(item: Item) {
        this.item = item
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
