package com.bhartenduKodes.nectar.ui.authentication

import android.app.NotificationManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentPhoneNumberBinding
import com.bhartenduKodes.nectar.utils.extensions.click
import com.bhartenduKodes.nectar.utils.extensions.sendSimpleNotification
import com.bhartenduKodes.nectar.utils.extensions.showMotionToast
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class PhoneNumberFragment :
    BaseFragment<FragmentPhoneNumberBinding>(FragmentPhoneNumberBinding::inflate) {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun initView() {
        binding.apply {
            fabMove.click {
                validateNumber()
            }
        }
    }

    private fun validateNumber() {
        val number = binding.etPhoneNumber.text.toString()
        binding.apply {
            if (number.count() == 10) {
                val action =
                    PhoneNumberFragmentDirections.actionPhoneNumberFragment2ToVerificationFragment2(number)
                findNavController().navigate(action)
                showMotionToast(
                    "Success",
                    "Please Enter a OTP",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                )
            } else{
                val action = PhoneNumberFragmentDirections.actionPhoneNumberFragment2ToSignInFragment2()
                findNavController().navigate(action)
                showMotionToast(
                    "warning",
                    "please enter Proper Number of 10 digits",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                )
            }
        }
    }
}