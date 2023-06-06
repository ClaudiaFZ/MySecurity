package com.example.mysecurity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mysecurity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        //binding.toolbar.setNavigationIcon(R.drawable.baseline_menu_24)
        /*binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }*/


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val appBarConfiguration =
            AppBarConfiguration(navHostFragment.navController.graph, binding.drawerLayout)

        binding.navView.setupWithNavController(navHostFragment.navController)
        binding.toolbar.setupWithNavController(navHostFragment.navController, appBarConfiguration)


    }

    /*val navController = findNavController(R.id.navigation)
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    val listener = object : NavigationUI.OnDestinationChangedListener {
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            // Actualizar el título de la barra superior
            supportActionBar?.title = destination.label
        }
    }
    NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
    navController.addOnDestinationChangedListener(listener)*/


}