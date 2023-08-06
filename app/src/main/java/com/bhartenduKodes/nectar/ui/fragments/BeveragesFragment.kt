package com.bhartenduKodes.nectar.ui.fragments

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentBeveragesBinding
import com.bhartenduKodes.nectar.ui.adapters.CommonAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class BeveragesFragment : BaseFragment<FragmentBeveragesBinding>(FragmentBeveragesBinding::inflate){

    private val beverageAdapter by lazy {
        CommonAdapter{
            val direction = BeveragesFragmentDirections.actionBeveragesFragmentToDetailsFragment(it)
            findNavController().navigate(direction)
        }
    }

    private val beverageViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun initView() {
        observer()
        getData()
        onClick()
        init()
    }

    private fun observer() {
        beverageViewModel.beverages.observe(viewLifecycleOwner){
            binding.apply {
                beverageAdapter.submitList(it)
            }
        }
    }

    private fun getData() {
        beverageViewModel.beverage()
    }

    private fun onClick() {
        binding.apply {
            views.btnText.text = getString(R.string.Beverages)
        }
    }

    private fun init() {
        binding.apply {
            rvBeverages.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL,false)
            rvBeverages.adapter = beverageAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }

}