package com.bhartenduKodes.nectar.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentSignInBinding
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import com.bhartenduKodes.nectar.ui.viewmodels.LoginViewModel
import com.bhartenduKodes.nectar.utils.extensions.click
import com.facebook.FacebookSdk
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate){

    private val auth = FirebaseAuth.getInstance()

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) {
        this.onSignInResult(it)
    }

    private val loginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun initView() {
        userSignedInOrNot()
        onClick()
    }

    private fun onSignInResult(res: FirebaseAuthUIAuthenticationResult) {
        if (res.resultCode == AppCompatActivity.RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            updateUI(user)
        } else {
            println("SignIn failed")
        }
    }

    private fun userSignedInOrNot() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            findNavController().navigate(R.id.onBoardingFragment2)
        }
    }

    private fun onClick() {
        binding.apply {
            rootCtnToPhoneNumber.click {
                val action = SignInFragmentDirections.actionSignInFragment2ToPhoneNumberFragment2()
                findNavController().navigate(action)
            }

            rootCtnToMail.click {
                val action = SignInFragmentDirections.actionSignInFragment2ToLoginFragment()
                findNavController().navigate(action)
            }

            rootCtnToGoogle.click {
                signInLauncher.launch(loginViewModel.initGoogleLogin())
            }

            rootCtnToFacebook.click {
                signInLauncher.launch(loginViewModel.initFacebookLogin())
            }
        }
    }


    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            activity?.finishAffinity()
        }
    }

}