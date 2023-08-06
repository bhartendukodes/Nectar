package com.bhartenduKodes.nectar.database.repo

import android.content.Context
import android.util.Log
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.data.model.toCartDto
import com.bhartenduKodes.nectar.data.model.toDto
import com.bhartenduKodes.nectar.database.database.CartDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepositoryDb(context: Context) {

    private val cartDao = CartDatabase.getMealDatabase(context)?.cartDao()

    fun getFavoriteData(): Flow<List<Product>>? {
        return cartDao?.getFavoriteData()
    }

    fun getCartData(): Flow<List<Product>>? {
        return cartDao?.getCartData()?.map { flow ->
            flow.map {
                it.toDto()
            }
        }
    }

    suspend fun updateProductInCart(product: Product) {
        if (product.quantity <= 0)
            cartDao?.deleteFromCart(product.toCartDto())
        else cartDao?.insertInCart(product.toCartDto())
    }

    suspend fun updateProductInFavorite(product: Product) {
        if (product.isFavorite)
            cartDao?.insertInFavorite(product)
        else cartDao?.deleteFromFavorite(product)
    }



}