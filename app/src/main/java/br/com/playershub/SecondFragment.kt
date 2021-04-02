package br.com.playershub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import br.com.playershub.databinding.FragmentSecondBinding

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
        viewModel.getGame(args.gameId)
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        with(viewModel) {
            gameDetails.observe(viewLifecycleOwner){
                binding.textView.text = it.toString()
            }
        }
    }
}