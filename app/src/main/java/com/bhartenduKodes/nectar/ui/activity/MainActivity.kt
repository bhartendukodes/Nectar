package com.bhartenduKodes.nectar.ui.activity

import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseActivity
import com.bhartenduKodes.nectar.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initView() {
        statusColor()
        binding.apply {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment
            val navController = navHostFragment.navController
            setUpBottomNavigation(navController)
        }
    }

    private fun statusColor() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window?.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }


    private fun setUpBottomNavigation(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }

}