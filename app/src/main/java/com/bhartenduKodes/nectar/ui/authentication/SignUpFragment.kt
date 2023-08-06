package com.bhartenduKodes.nectar.ui.authentication

import android.content.Intent
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentSignUpBinding
import com.bhartenduKodes.nectar.ui.activity.AuthenticationActivity
import com.bhartenduKodes.nectar.utils.extensions.click
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    private lateinit var fStore: FirebaseFirestore

    override fun initView() {
        onClick()
        initiUi()
    }

    private fun initiUi() {
        fStore = FirebaseFirestore.getInstance()
    }

    private fun onClick() {

        binding.apply {
            btnSignUp.click {
                clickEvent()
            }
        }

    }

    private fun clickEvent() {
        binding.apply {
            val fullName = etUserName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPasswordLogin.text.toString().trim()
            if (email.isEmpty())
                layoutEmailInput.error = "Please Enter Your Email Address"
            else if (password.isEmpty())
                layoutPasswordInput.error = "Please Enter Your Password"
            else if (fullName.isEmpty())
                layoutNameInput.error = "Please Enter Your Name"
            else {
                initEmailSignUp(fullName, email, password)
            }
        }
    }

    private fun initEmailSignUp(fullName: String, email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "createUserWithEmail:success")
                    val user = FirebaseAuth.getInstance().currentUser
                    val updateProfile =
                        UserProfileChangeRequest.Builder().setDisplayName(fullName).build()
                    user?.updateProfile(updateProfile)?.addOnCompleteListener {
                        if (it.isSuccessful) {
                            updateUI(user)
                        }
                    }
                    val users = hashMapOf(
                        "fullName" to fullName,
                        "email" to email,
                        "password" to password
                    )
                    fStore.collection("users")
                        .add(users)
                        .addOnSuccessListener { documentReference ->
                            Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                            showMotionToast(
                                "Success",
                                "Successfully Created Your Account",
                                MotionToastStyle.SUCCESS,
                                MotionToast.GRAVITY_BOTTOM,
                            )
                        }
                        .addOnFailureListener { e ->
                            showMotionToast(
                                "Success",
                                "${task.exception?.message}",
                                MotionToastStyle.SUCCESS,
                                MotionToast.GRAVITY_BOTTOM,
                            )
                        }
                } else {
                    showMotionToast(
                        "Failure",
                        "${task.exception?.message}",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                    )
                }
            }
    }

    private fun updateUI(user: FirebaseUser) {
        if (user != null) {
            startActivity(Intent(requireContext(), AuthenticationActivity::class.java))
            activity?.finishAffinity()
        }
    }

}