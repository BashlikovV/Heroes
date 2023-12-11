package by.bashlikovvv.heroes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.bashlikovvv.heroes.databinding.ItemProgressBinding

class ItemProgressViewHolder(
    binding: ItemProgressBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): ItemProgressViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)

            return ItemProgressViewHolder(
                ItemProgressBinding.inflate(layoutInflater, parent, false)
            )
        }
    }

}