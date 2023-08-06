package com.bhartenduKodes.nectar.ui.fragments

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.databinding.FragmentHomeBinding
import com.bhartenduKodes.nectar.ui.adapters.ExclusiveAdapter
import com.bhartenduKodes.nectar.ui.adapters.GroceriesAdapter
import com.bhartenduKodes.nectar.ui.adapters.ImageSliderAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val exclusiveViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val exclusiveOfferAdapter by lazy {
        ExclusiveAdapter{
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    private lateinit var offersSliderAdapter: ImageSliderAdapter

    private val exclusiveBestSellingAdapter by lazy {
        ExclusiveAdapter{
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    private val groceriesAdapter by lazy {
        GroceriesAdapter()
    }

    override fun initView() {
        observer()
        init()
        getData()
        onClick()
    }

    private fun observer() {
        exclusiveViewModel.exclusiveOffer.observe(viewLifecycleOwner){
            binding.apply {
                exclusiveOfferAdapter.submitList(it)
            }
        }

        exclusiveViewModel.bestSelling.observe(viewLifecycleOwner){
            binding.apply {
                exclusiveBestSellingAdapter.submitList(it)
            }
        }
        exclusiveViewModel.groceries.observe(viewLifecycleOwner){
            binding.apply {
                groceriesAdapter.submitList(it)
                Log.d("groceriesList", "$it")
            }
        }
    }

    private fun init() {
        binding.apply {

            offersSliderAdapter= ImageSliderAdapter()
             exlusiveOffierSlider.setSliderAdapter(offersSliderAdapter)
             exlusiveOffierSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
             exlusiveOffierSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
             exlusiveOffierSlider.startAutoCycle()

            rvExclusiveOffers.apply{
                layoutManager=
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter=exclusiveOfferAdapter
            }
            rvBestSelling.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = exclusiveBestSellingAdapter
            }
            rvGroceries.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = groceriesAdapter
            }
        }
    }

    private fun getData() {
        exclusiveViewModel.exclusiveOffer()
        exclusiveViewModel.bestSelling()
        exclusiveViewModel.groceries()
    }

    private fun onClick() {
        binding.apply {
            tvBestSellings.click {
                findNavController().navigate(R.id.findProductFragment)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.VISIBLE
    }
}