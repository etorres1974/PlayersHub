package br.com.playershub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.playershub.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val viewModel: ViewModel by viewModels()

    private lateinit var gameAdapter : GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        subscribeUi()
        viewModel.listFreeGames()
    }

    private fun subscribeUi(){
        with(viewModel){
            games.observe(viewLifecycleOwner){ list -> gameAdapter.submitList(list)}
        }
    }

    private fun setupUi(){
        setupRecyclerView()
        with(binding){
            buttonSecond.setOnClickListener { navigate() }
        }
    }

    private fun setupRecyclerView(){
        gameAdapter = GameAdapter()
        binding.recyclerViewGames.adapter = gameAdapter
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
}