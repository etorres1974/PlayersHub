package br.com.components

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.core.view.postOnAnimationDelayed
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.playershub.R
import br.com.playershub.databinding.CarousselBinding
import br.com.playershub.domain.entity.Game
import kotlinx.coroutines.delay
import android.util.Log
class GamesCarousels(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding = CarousselBinding.inflate(LayoutInflater.from(context), this, true)
    private val title =
        context.theme.obtainStyledAttributes(attrs, R.styleable.GamesCarousels, 0, 0)
            .getString(R.styleable.GamesCarousels_title)

    init {
        binding.recyclerTitle = title
    }

    fun setPagedViewModel(viewModel: GamesViewModel) {
        with(binding.recyclerView) {
            adapter = GamePagedAdapter(viewModel::fetchGamesDetail)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun setSubmitPagedGames(list: PagedList<Game>?) {
        with(binding.recyclerView) {
            (this.adapter as GamePagedAdapter).submitList(list)
        }
    }
}