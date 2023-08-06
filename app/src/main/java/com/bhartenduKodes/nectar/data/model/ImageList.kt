package com.bhartenduKodes.nectar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageList(
    val name:String,
    var price:Double,
    val quantity: Int,
    val priceType:String,
    val imgId: Int
) : Parcelable