package com.bhartenduKodes.nectar.ui.fragments

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentMeatAndFishBinding
import com.bhartenduKodes.nectar.ui.adapters.ExclusiveAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MeatAndFishFragment :
    BaseFragment<FragmentMeatAndFishBinding>(FragmentMeatAndFishBinding::inflate) {

    private val meatAndFishAdapter by lazy {
        ExclusiveAdapter{
            val action = MeatAndFishFragmentDirections.actionMeatAndFishFragmentToDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    private val meatViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun initView() {
        observer()
        initViews()
        onClick()
        getData()
    }

    private fun onClick() {
        binding.apply {
            views.btnText.text= getString(R.string.meatandFish)
        }
    }

    private fun observer() {
        meatViewModel.meatFish.observe(viewLifecycleOwner){
            binding.apply {
                meatAndFishAdapter.submitList(it)
            }
        }
    }

    private fun getData() {
        meatViewModel.meatAndFish()
    }

    private fun initViews() {
        binding.apply {
            rvNonVeg.apply {
                layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
                adapter = meatAndFishAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
    }
}


