package com.bhartenduKodes.nectar.ui.viewmodels

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.AuthUI

class LoginViewModel:ViewModel() {

    fun initGoogleLogin(): Intent {
        val provides= arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(provides)
            .build()
    }

    fun initFacebookLogin():Intent {
        val providers = arrayListOf(
            AuthUI.IdpConfig.FacebookBuilder().build()
        )
        return AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
    }
}