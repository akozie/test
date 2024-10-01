package com.migrapay.androidmigrapay.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.migrapay.androidmigrapay.R
import com.migrapay.androidmigrapay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        navController = findNavController(R.id.container_main)
//        navigationView = binding.navView

        bottomNavigationView =
            binding.dashboardBottomNavigationView

        appBarConfiguration =
            AppBarConfiguration(
                navController.graph,
            )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navigationView.setupWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)

        onDestinationChangedListener()
    }

    private fun onDestinationChangedListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            //  toolbarFragmentName.text = destination.label ?: getString(androidx.navigation.ui.R.string.app_name)
            // toolbarFragmentName.setTextColor(Color.WHITE)
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
                R.id.mobileRechargeFragment -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
                else -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
