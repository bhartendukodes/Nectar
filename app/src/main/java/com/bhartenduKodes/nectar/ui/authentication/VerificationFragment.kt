package com.bhartenduKodes.nectar.ui.authentication

import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentVerificationBinding
import com.bhartenduKodes.nectar.ui.activity.AuthenticationActivity
import com.bhartenduKodes.nectar.ui.activity.MainActivity
import com.bhartenduKodes.nectar.utils.extensions.click
import com.bhartenduKodes.nectar.utils.extensions.sendSimpleNotification
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import com.bhartenduKodes.nectar.utils.extensions.showToastShort
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.util.concurrent.TimeUnit

class VerificationFragment :
    BaseFragment<FragmentVerificationBinding>(FragmentVerificationBinding::inflate) {

    private lateinit var auth: FirebaseAuth
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private var phoneNum: String = "+91"
    private var storedVerificationId: String? = null
    private val args: VerificationFragmentArgs by navArgs()


    override fun initView() {
        initUi()
        verificationCallbacks()
        onClick()
    }

    private fun initUi() {
        auth = FirebaseAuth.getInstance()
        auth.useAppLanguage()
    }

    private fun verificationCallbacks() {

       val  phoneNumber = phoneNum + args.data

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @RequiresApi(Build.VERSION_CODES.S)
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                val code = credential.smsCode
                if (code != null) {
                    verifyVerificationCode(code)

                    val notificationManager = requireContext().getSystemService(
                        AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
                    notificationManager.sendSimpleNotification("888-11","Your Code is $code", requireContext())

                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                when (e) {
                    is FirebaseAuthInvalidCredentialsException -> {
                        // Invalid request
                        showToastShort("Invalid request")
                        returnToEnterNumberActivity()
                    }
                    is FirebaseTooManyRequestsException -> {
                        // The SMS quota for the project has been exceeded
                        showToastShort("The SMS quota for the project has been exceeded")
                        returnToEnterNumberActivity()
                    }
                    else -> {
                        showToastShort(e.message.toString())
                        returnToEnterNumberActivity()
                    }
                }
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:$verificationId")
                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                resendToken = token
                showToastShort("OTP sent to $phoneNum")
                super.onCodeSent(verificationId, resendToken)
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity())                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }

    private fun onClick() {
        binding.apply {
            fabNext.click {
                if (etOtp.text.toString().isNotEmpty()) {
                    etOtp.clearFocus()
                    etOtp.text?.toString()?.let { verifyVerificationCode(it) }
                } else {
                    etOtp.error = "Enter OTP 🤨"
                    etOtp.requestFocus()
                    return@click
                }
            }
        }
    }

    private fun verifyVerificationCode(code: String) {
        //creating the credential
        val credential = PhoneAuthProvider.getCredential(storedVerificationId!!, code)
        //signing the user
        signInWithPhoneAuthCredential(credential)

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->

                if (task.isSuccessful) {

                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    showMotionToast(
                        "Success",
                        "Authorization Completed \uD83E\uDD73\uD83E\uDD73",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                    )

                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()

                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        showMotionToast(
                            "failed",
                            "The verification code entered was invalid \uD83E\uDD7A",
                            MotionToastStyle.ERROR,
                            MotionToast.GRAVITY_BOTTOM,
                        )
                    } else {
                        // Update UI
                        showToastShort(task.exception?.message.toString())
                    }
                    returnToEnterNumberActivity()

                }
            }
    }

    private fun returnToEnterNumberActivity() {
        val intent = Intent(requireContext(), AuthenticationActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }



}


