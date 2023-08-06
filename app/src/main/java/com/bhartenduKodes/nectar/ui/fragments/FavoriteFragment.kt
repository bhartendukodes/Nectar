package com.bhartenduKodes.nectar.ui.fragments

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhartenduKodes.nectar.base.BaseFragment
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModel
import com.bhartenduKodes.nectar.database.viewmodel.CartViewModelFactory
import com.bhartenduKodes.nectar.databinding.FragmentFavoriteBinding
import com.bhartenduKodes.nectar.ui.adapters.FavoriteAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val favoriteAdapter by lazy {
        FavoriteAdapter()
    }

    private val cartViewModel by lazy {
        ViewModelProvider(this, CartViewModelFactory(requireContext()))[CartViewModel::class.java]
    }

    override fun initView() {
        observer()
        initViewss()
    }

    private fun initViewss() {
        binding.apply {
            incCart.tvName.text = "Favorurite"

            rvFavoriteAdapter.adapter = favoriteAdapter

            rvFavoriteAdapter.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = favoriteAdapter
            }
        }
    }


    private fun observer() {
        lifecycleScope.launch {
            cartViewModel.getFavProducts()?.collectLatest {favProducts ->
                withContext(Dispatchers.Main) {
                    Log.e("GetFavData","ItemList -> $favProducts")
                    favoriteAdapter.submitList(favProducts)
                }
            }
        }
    }

}