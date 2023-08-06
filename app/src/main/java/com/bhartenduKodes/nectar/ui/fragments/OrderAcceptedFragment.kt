package com.bhartenduKodes.nectar.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentOrderAccepted2Binding
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.android.material.bottomnavigation.BottomNavigationView


class OrderAcceptedFragment : BaseFragment<FragmentOrderAccepted2Binding>(FragmentOrderAccepted2Binding::inflate) {
    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            mbHome.click {
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }


    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }
}