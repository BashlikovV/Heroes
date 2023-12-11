package by.bashlikovvv.heroes.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import by.bashlikovvv.heroes.domain.model.Hero
import by.bashlikovvv.heroes.domain.model.Item

class HeroDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

}