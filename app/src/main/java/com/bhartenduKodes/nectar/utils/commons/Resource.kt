package com.bhartenduKodes.nectar.utils.commons

import com.bhartenduKodes.nectar.utils.helpers.PojoUtils
import okhttp3.ResponseBody

class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null) {

    companion object {
        fun <T> success(data: T?, message: String? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, message)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING)
        }

        fun <T> error(errorBody: ResponseBody?, data: T?): Resource<T> {
            val errorResponse: CommonResponse<Any> =
                PojoUtils.getResponse(errorBody?.charStream())

            return Resource(Status.ERROR, message = errorResponse.message)
        }

        fun <T> timeOut(message: String = "Something went wrong!!"): Resource<T> {
            return Resource(status = Status.GATEWAY, message = message)
        }
    }
}