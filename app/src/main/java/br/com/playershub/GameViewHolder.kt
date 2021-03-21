package br.com.playershub

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.playershub.databinding.ItemGameBinding
import br.com.playershub.domain.entity.Game

class GameViewHolder(
    private val binding: ItemGameBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game : Game){
        binding.game = game
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