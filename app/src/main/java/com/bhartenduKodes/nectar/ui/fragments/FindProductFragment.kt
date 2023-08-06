package com.bhartenduKodes.nectar.ui.fragments

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.data.dummydata.Actions
import com.bhartenduKodes.nectar.databinding.FragmentFindProductBinding
import com.bhartenduKodes.nectar.ui.adapters.ProductListedAdapter
import com.bhartenduKodes.nectar.ui.viewmodels.HomeViewModel

class FindProductFragment : BaseFragment<FragmentFindProductBinding>(FragmentFindProductBinding::inflate) {

    private val findProductViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val productAdapter by lazy {
        ProductListedAdapter{
            when(it) {
                Actions.MEAT_AND_FISH ->{
                    val action = FindProductFragmentDirections.actionFindProductFragmentToMeatAndFishFragment()
                    findNavController().navigate(action)
                }
                Actions.BEVERAGE ->{
                    val action = FindProductFragmentDirections.actionFindProductFragmentToBeveragesFragment()
                    findNavController().navigate(action)
                }
                Actions.FRESH_FRUITS_VEGETABLES ->{
                    val action = FindProductFragmentDirections.actionFindProductFragmentToFreshFruitsFragment()
                    findNavController().navigate(action)
                }
                else -> {}
            }
        }
    }

    override fun initView() {
        init()
        observer()
        setData()
    }

    private fun setData() {
        binding.apply {
            incProduct.tvName.text=getString(R.string.find_product)
        }
        findProductViewModel.findProduct()
    }

    private fun observer() {
        findProductViewModel.products.observe(viewLifecycleOwner){
            productAdapter.submitList(it)
        }
    }

    private fun init() {
        binding.apply {
            rvFindProducts.layoutManager=
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            rvFindProducts.adapter=productAdapter
        }
    }


}