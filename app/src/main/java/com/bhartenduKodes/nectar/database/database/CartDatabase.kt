package com.bhartenduKodes.nectar.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhartenduKodes.nectar.data.model.CartProduct
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.database.dao.CartDao

@Database(entities = [Product::class,CartProduct::class], version = 2, exportSchema = false)
abstract class CartDatabase:RoomDatabase() {

    abstract fun cartDao():CartDao

    companion object{
        private var INSTANCE: CartDatabase?=null

        fun getMealDatabase(applicationContext: Context): CartDatabase?{
            if (INSTANCE ==null)
            {
                INSTANCE =
                    Room.databaseBuilder(applicationContext, CartDatabase::class.java, "cartDb").fallbackToDestructiveMigration().build()
            }
            return INSTANCE
        }
    }
}