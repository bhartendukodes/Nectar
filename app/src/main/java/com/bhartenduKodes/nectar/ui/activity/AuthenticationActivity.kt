package com.bhartenduKodes.nectar.ui.activity

import android.content.Intent
import android.view.View
import com.bhartenduKodes.nectar.base.BaseActivity
import com.bhartenduKodes.nectar.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : BaseActivity<ActivityAuthenticationBinding>(ActivityAuthenticationBinding::inflate){
    override fun initView() {
        fullScreen()
    }

    private fun fullScreen() {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}