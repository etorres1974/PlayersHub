package br.com.components

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.com.playershub.domain.entity.Game

class GameAdapter(
    private val callback : (Int) -> Unit
) : ListAdapter<Game, GameViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(currentList[position], callback)
    }

    override fun getItemCount(): Int = currentList.size

    companion object DiffUtilCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Game, newItem: Game) =
            oldItem.name == newItem.name
    }
}