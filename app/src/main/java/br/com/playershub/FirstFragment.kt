package br.com.playershub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.playershub.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val rawgGamesViewModel: RawgGamesViewModel by activityViewModels()
    private val freeGamesViewModel: FreeGamesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        with(binding) {
           freeViewModel = freeGamesViewModel
           rawgViewModel = rawgGamesViewModel
           lifecycleOwner = this@FirstFragment
           freeGamesViewModel.openDetails.observe(this@FirstFragment.viewLifecycleOwner, ::navigateToDetails)
        }
    }

    private fun navigateToDetails(gameId : Int) {
        var action = FirstFragmentDirections.actionToDetailsFragment(gameId)
        findNavController().navigate(action)
    }
}