package com.bhartenduKodes.nectar.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentFreshFruitsBinding
import com.bhartenduKodes.nectar.ui.adapters.ExclusiveAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.android.material.bottomnavigation.BottomNavigationView

class FreshFruitsFragment :BaseFragment<FragmentFreshFruitsBinding>(FragmentFreshFruitsBinding::inflate){

    private val freshFruitsAdapter by lazy {
        ExclusiveAdapter{
            val data = FreshFruitsFragmentDirections.actionFreshFruitsFragmentToDetailsFragment(it)
            findNavController().navigate(data)
        }
    }

    private val freshFruitsViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun initView() {
        observer()
        onClick()
        initData()
    }

    private fun observer() {
        freshFruitsViewModel.freshFruits.observe(viewLifecycleOwner){
            binding.apply {
                freshFruitsAdapter.submitList(it)
            }
        }
    }

    private fun onClick() {
        binding.apply {
            views.btnBack.click {
                val action = FreshFruitsFragmentDirections.actionFreshFruitsFragmentToFindProductFragment()
                findNavController().navigate(action)

            }
        }
    }

    private fun initData() {
        freshFruitsViewModel.freshFruits()

        binding.apply {
            rvFreshFruits.apply {
                layoutManager = GridLayoutManager(
                    requireContext(), 2,
                    GridLayoutManager.VERTICAL, false
                )
                adapter = freshFruitsAdapter
            }
            "Fresh Fruits And Vegetables".also { views.btnText.text = it }
        }
    }


    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }
}



