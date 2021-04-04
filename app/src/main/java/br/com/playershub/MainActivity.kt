package br.com.playershub

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.playershub.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private val viewModel: RawgGamesViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        lifecycle.addObserver(viewModel)
        setupToolbar()
        subscribeUi()
    }

    private fun setupToolbar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = navHostFragment!!.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        navController.addOnDestinationChangedListener(this)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        with(destination as FragmentNavigator.Destination) {
            when (className) {
                FirstFragment::class.java.name -> binding.toolbar.visibility = View.GONE
                SecondFragment::class.java.name -> binding.toolbar.visibility = View.VISIBLE
                else -> Log.d("LOG", " ERROR unknown fragment name : $className")
            }
        }
    }

    private fun subscribeUi() {
        subscribeLoading()
        viewModel.newDestination.observe(this, navController::navigate)
    }

    private fun subscribeLoading() {
        viewModel.loading.observe(this) { show ->
            if (show)
                binding.loading.visibility = View.VISIBLE
            else
                binding.loading.visibility = View.GONE
        }
    }
}