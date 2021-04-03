package br.com.playershub

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import br.com.playershub.databinding.FragmentSecondBinding
import br.com.playershub.domain.entity.GameDetails
import br.com.util.loadImageUrl

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val viewModel: RawgGamesViewModel by activityViewModels()

    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        with(viewModel) {
            gameDetails.observe(viewLifecycleOwner, ::setupGameDetail)
        }
    }

    fun setupGameDetail(gameDetails: GameDetails) {
        with(binding) {
            with(gameDetails) {
                altImage?.let { imageView.loadImageUrl(it) }
                description?.let { textViewDescription.text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT)  }

            }
        }
    }
}