package br.com.playershub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.playershub.databinding.FragmentFirstBinding
import br.com.playershub.domain.entity.Game

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding

    private val viewModel: ViewModel by viewModels()

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
    private fun subscribeUi(){
        with(viewModel){
            games.observe(viewLifecycleOwner, ::setRecyclerViewContent)
        }
    }

    private fun setupUi(){
        with(binding){
            buttonFirst.setOnClickListener { navigate() }
        }
    }

    private fun setRecyclerViewContent(list : List<Game>){
        (binding.recyclerViewGames.adapter as GameAdapter).submitList(list)
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}