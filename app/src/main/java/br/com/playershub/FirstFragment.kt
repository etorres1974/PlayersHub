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

    private val viewModel: GamesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        subscribeUi()
        viewModel.listRawgGames()
    }

    private fun subscribeUi() {
        with(viewModel) {
            games.observe(viewLifecycleOwner, binding.recyclerViewGames::submitGames)
        }
    }

    private fun setupUi() {
        with(binding) {
            buttonFirst.setOnClickListener { navigate() }
        }
    }

    private fun navigate() {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}