package com.bhartenduKodes.nectar.ui.authentication

import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentOnBoardingBinding
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class OnBoardingFragment :BaseFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate){

    private val auth = FirebaseAuth.getInstance()

    override fun initView() {
        onClick()
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

    private fun onClick() {
        binding.apply {
            btnStarted.click {
                val action = OnBoardingFragmentDirections.actionOnBoardingFragment2ToSignInFragment2()
                findNavController().navigate(action)
            }
        }
    }

}