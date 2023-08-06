package com.bhartenduKodes.nectar.utils.commons


import com.google.gson.annotations.SerializedName

data class CommonResponse<T>(
    @SerializedName("data")
    val data: T?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
)