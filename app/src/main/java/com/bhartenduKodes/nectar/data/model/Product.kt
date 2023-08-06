package com.bhartenduKodes.nectar.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favorite_table")
data class Product(
    @PrimaryKey
    var id: Int,
    val name:String,
    val quantityDescription:String,
    val amount: Double,
    var img: Int,
    var quantity: Int,
    var description: String,
    var isFavorite:Boolean = false
):Parcelable




@Parcelize
@Entity(tableName = "cart_table")
data class CartProduct(
    @PrimaryKey
    var id: Int,
    val name:String,
    val quantityDescription: String,
    val amount: Double,
    val quantity:Int,
    var img: Int,
    var description: String,
    val isFavorite: Boolean
):Parcelable

fun Product.toCartDto() = CartProduct(id = id, quantity = quantity, name = name, quantityDescription = quantityDescription, img = img, description = description,amount = amount, isFavorite = isFavorite)
fun CartProduct.toDto() = Product(id = id,quantity = quantity,name = name, quantityDescription = quantityDescription, img = img, description = description,amount = amount, isFavorite = isFavorite)



