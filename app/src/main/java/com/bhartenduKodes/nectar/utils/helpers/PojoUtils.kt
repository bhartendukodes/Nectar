package com.bhartenduKodes.nectar.utils.helpers

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.bhartenduKodes.nectar.utils.commons.CommonResponse
import java.io.Reader

object PojoUtils {

    inline fun <reified T : Any> getResponse(data: JsonObject?): T {
        return Gson().fromJson(data, T::class.java)
    }

    inline fun <reified T : Any> stringToObject(jsonString: String?): T? {
        return Gson().fromJson(jsonString, T::class.java) ?: null
    }

    inline fun <reified T : Any> toString(data: T?): String? {
        return Gson().toJson(data)
    }

    fun <T> getObjectList(jsonString: String?, cls: Class<T>?): List<T> {
        val list: MutableList<T> = ArrayList()
        try {
            val gson = Gson()
            val array = JsonParser.parseString(jsonString).asJsonArray
            for (jsonElement in array) {
                list.add(gson.fromJson(jsonElement, cls))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun <T : Any> anyToObject(data: Any): T {
        val jsonObject = Gson().toJsonTree(data).asJsonObject;
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(jsonObject, type)
    }

    fun <T : Any> getResponse(charStream: Reader?): T {
        val type = object : TypeToken<CommonResponse<T>>() {}.type
        return Gson().fromJson(charStream, type)
    }

    fun <T : Any> errorBodyToObject(charStream: Reader?): CommonResponse<T> {
        val type = object : TypeToken<CommonResponse<T>>() {}.type
        return Gson().fromJson(charStream, type)
    }

}