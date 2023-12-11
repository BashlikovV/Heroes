package by.bashlikovvv.heroes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.bashlikovvv.heroes.databinding.ItemHeroBinding
import by.bashlikovvv.heroes.domain.model.Hero
import com.bumptech.glide.Glide

class ItemHeroViewHolder(
    private val binding: ItemHeroBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: Hero, onClick: (Hero) -> Unit) {
        Glide.with(binding.heroImageView)
            .load(hero.imageUrl)
            .into(binding.heroImageView)
        binding.heroNameTextView.text = hero.name
        binding.root.setOnClickListener { onClick(hero) }
    }

    companion object {
        fun from(parent: ViewGroup): ItemHeroViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)

            return ItemHeroViewHolder(ItemHeroBinding.inflate(layoutInflater, parent, false))
        }
    }

}