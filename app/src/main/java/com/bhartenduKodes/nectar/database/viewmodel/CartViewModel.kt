package com.bhartenduKodes.nectar.database.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.database.repo.RepositoryDb
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CartViewModel(context: Context) : ViewModel() {

    private val repo: RepositoryDb = RepositoryDb(context)

    fun getFavProducts(): Flow<List<Product>>? {
        return repo.getFavoriteData()
    }

    fun getCartProducts(): Flow<List<Product>>? {
        return repo.getCartData()
    }

    fun insertProductInFavorite(product: Product) {
        try {
            viewModelScope.launch {
                repo.updateProductInFavorite(product)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }




//    fun insertProductInFavorite(product: Product) {
//        try {
//            viewModelScope.launch {
//                repo.updateProductInFavorite(product.copy(isFavorite = !product.isFavorite))
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

    fun updateProductInCart(product: Product) {
        try {
            viewModelScope.launch {
                Log.e("UpdateCart","$product")
                repo.updateProductInCart(product)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}