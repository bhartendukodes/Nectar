package com.bhartenduKodes.nectar.ui.authentication

import android.content.Intent
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentLoginBinding
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import com.bhartenduKodes.nectar.utils.extensions.click
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val auth = FirebaseAuth.getInstance()

    override fun initView() {
        onClick()
        userSignedInOrNot()
    }

    private fun userSignedInOrNot() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    private fun onClick() {
        binding.apply {
            mbLogin.click {
                validateEmailAndPassword()
            }
            tvSignUp.click {
                val action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment2()
                findNavController().navigate(action)
            }
            layoutEmailInput.click {
                layoutEmailInput.error = "Please Enter Email Address"
            }
            layoutPasswordInput.click {
                layoutPasswordInput.error = "Please Enter Password"
            }
        }
    }

    private fun validateEmailAndPassword() {
        binding.apply {
            if (etEmail.text.toString().trim().isEmpty()) {
                binding.layoutEmailInput.error = "Empty"
            } else if (binding.etPasswordLogin.text.toString().trim().isEmpty()) {
                binding.layoutPasswordInput.error = "Empty"
            } else {
                binding.layoutEmailInput.refreshErrorIconDrawableState()
                initEmailLogin(
                    binding.etEmail.text.toString().trim(),
                    binding.etPasswordLogin.text.toString().trim()
                )
            }
        }
    }

    private fun initEmailLogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    showMotionToast(
                        "Success",
                        "Login Successfully",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION
                    )
                    updateUI(user)
                } else {
                    showMotionToast(
                        "failed",
                        "${task.exception?.message}",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION,
                        ResourcesCompat.getFont(
                            requireContext(),
                            www.sanju.motiontoast.R.font.montserrat_regular
                        )
                    )
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