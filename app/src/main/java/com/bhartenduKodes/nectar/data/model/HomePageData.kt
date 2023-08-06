package com.bhartenduKodes.nectar.data.model

import android.os.Parcelable
import com.bhartenduKodes.nectar.data.dummydata.Actions
import kotlinx.parcelize.Parcelize


data class SettingData(
    var id:Int,
    val img:Int,
    val name:String,
)

@Parcelize
data class ProductCategory(
    val id: Int,
    val name: String,
    val image: Int,
    val bgColor:Int,
    val action: Actions
):Parcelable