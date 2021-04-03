package br.com.components

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.playershub.domain.entity.Game

class GamePagedAdapter(
    private val callback: (Int) -> Unit
) : PagedListAdapter<Game, GameViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, callback) }
    }

    override fun getItemCount(): Int = currentList?.size ?: 0

    companion object DiffUtilCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Game, newItem: Game) =
            oldItem.name == newItem.name
    }
}