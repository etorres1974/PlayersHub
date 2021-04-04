package br.com.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.playershub.R
import br.com.playershub.databinding.ItemGameBinding
import br.com.playershub.domain.entity.Game
import br.com.util.loadImageUrl


class GameViewHolder(
    private val binding: ItemGameBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: Game, callback: (Int, String?) -> Unit) {
        binding.game = game
        binding.root.setOnClickListener {  callback(game.id, game.name)}
        game.image?.let {
            binding.imageView.loadImageUrl(it)
        }
    }

    companion object {
        fun inflate(parent: ViewGroup) = GameViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}