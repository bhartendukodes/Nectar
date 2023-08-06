package com.bhartenduKodes.nectar.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bhartenduKodes.nectar.data.model.CartProduct
import com.bhartenduKodes.nectar.data.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInCart(product: CartProduct)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInFavorite(product: Product)

    @Delete
    suspend fun deleteFromFavorite(product: Product)

    @Delete
    suspend fun deleteFromCart(product: CartProduct)

    @Query("SELECT * FROM favorite_table")
    fun getFavoriteData(): Flow<List<Product>>

    @Query("Select * from cart_table")
    fun getCartData():Flow<List<CartProduct>>

}