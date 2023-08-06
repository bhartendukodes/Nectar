package com.bhartenduKodes.nectar.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseActivity
import com.bhartenduKodes.nectar.databinding.ActivitySplashBinding
import com.bhartenduKodes.nectar.ui.activity.AuthenticationActivity
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun initView() {
        statusColor()
        navigate()
    }

    private fun navigate() {
        lifecycleScope.launchWhenStarted {
            delay(3000)
            startActivity(Intent(this@SplashActivity, AuthenticationActivity::class.java))
            finishAffinity()
        }
    }

    private fun statusColor() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window?.statusBarColor = ContextCompat.getColor(this, R.color.app_color)
    }
}