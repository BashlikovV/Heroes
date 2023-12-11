package by.bashlikovvv.heroes.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.bashlikovvv.heroes.domain.model.Hero
import by.bashlikovvv.heroes.domain.model.Item

class HeroesListAdapter(
    private val onClickListener: (Hero) -> Unit,
    private val onListEndedCallback: () -> Unit,
    private val onListStartedCallback: () -> Unit
) : androidx.recyclerview.widget.ListAdapter<Item, RecyclerView.ViewHolder>(HeroDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HERO) {
            ItemHeroViewHolder.from(parent)
        } else {
            ItemProgressViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item is Hero) {
            (holder as ItemHeroViewHolder).bind(item, onClickListener)
        } else {
            holder as ItemProgressViewHolder
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (position == itemCount - 1) { onListEndedCallback() }
        if (position == 0) { onListStartedCallback() }
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position) is Hero) {
            TYPE_HERO
        } else {
            TYPE_PROGRESS
        }
    }

    companion object {
        const val TYPE_HERO = 0
        const val TYPE_PROGRESS = 1
    }

}