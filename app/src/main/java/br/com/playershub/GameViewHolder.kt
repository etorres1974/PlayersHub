package br.com.playershub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.playershub.databinding.ItemGameBinding
import br.com.playershub.domain.entity.Game
import br.com.util.loadImageUrl
import com.squareup.picasso.Picasso


class GameViewHolder(
    private val binding: ItemGameBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(game: Game) {
        binding.game = game
        game.image?.let{
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