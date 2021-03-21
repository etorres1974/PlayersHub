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
        viewModel.listRawgGames()
        setupUi()
        subscribeUi()
    }
    fun subscribeUi(){
        with(viewModel){
            games.observe(viewLifecycleOwner, ::loadAdapter)
        }
    }

    fun loadAdapter(list : List<Game>){
        Log.d("List on First Frag ", list.toString())
    }

    fun setupUi(){
        with(binding){
            buttonFirst.setOnClickListener { navigate() }

        }
    }

    fun navigate(){
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}