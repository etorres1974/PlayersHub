package br.com.playershub.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.playershub.R
import br.com.playershub.RawgGamesViewModel
import br.com.playershub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RawgGamesViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(RawgGamesViewModel::class.java)
        lifecycle.addObserver(viewModel)

        setupToolbar()
        subscribeUi()
    }

    private fun setupToolbar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        navController = navHostFragment!!.findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun subscribeUi(){
        subscribeLoading()
        viewModel.newDestination.observe(this, navController::navigate)
    }

    private fun subscribeLoading() {
        viewModel.loading.observe(this) { show ->
            if (show)
                binding.loading.show()
            else
                binding.loading.hide()
        }
    }
}