package com.bhartenduKodes.nectar.ui.fragments

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModel
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModelFactory
import com.bhartenduKodes.nectar.databinding.FragmentCartBinding
import com.bhartenduKodes.nectar.ui.adapters.CartAdapter
import com.bhartenduKodes.nectar.utils.extensions.click
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    private val cartViewModel by lazy {
        ViewModelProvider(this, CartViewModelFactory(requireContext()))[CartViewModel::class.java]
    }

    private val cartAdapter by lazy {
        CartAdapter { cartItem ->
            cartViewModel.updateProductInCart(cartItem)
        }
    }

    override fun initView() {
        initi()
        observer()
        onClick()
    }

    private fun onClick() {
        binding.apply {
            mbuttonCart.click {
                val totalAmount = cartAdapter.getTotalAmount()
                val action = CartFragmentDirections.actionCartFragmentToCheckOutFragment(totalAmount.toLong())
                findNavController().navigate(action)
            }
        }
    }

    private fun initi() {
        binding.apply {


            incCart.tvName.text = getString(R.string.cart)


            rvMyCart.adapter = cartAdapter

            rvMyCart.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = cartAdapter
            }
        }
    }



    private fun observer() {
        lifecycleScope.launch {
            cartViewModel.getCartProducts()?.collectLatest { cartProducts ->
                withContext(Dispatchers.Main) {
                    Log.e("GetCartData", "ItemList -> $cartProducts")
                    cartAdapter.submitList(cartProducts)


                    val totalAmount = cartAdapter.getTotalAmount()
                    binding.tvTotalAmountAmount.text = totalAmount.toString()

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.VISIBLE
    }


}