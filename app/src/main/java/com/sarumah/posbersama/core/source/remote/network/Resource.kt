package com.sarumah.posbersama.core.source.remote.network

import com.sarumah.posbersama.util.Constants

data class Resource<out T>(
    val state: State, val body: T?, val message: String? = null, val errorCode: String? = null) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(State.SUCCESS, data)
        }

        fun <T> error(msg: String?, errorCode: String?): Resource<T> {
            return Resource(
                State.ERROR,
                    null,
                    msg ?: Constants.DEFAULT_ERROR,
                    errorCode ?: "ERROR"
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource(State.LOADING, body = null)
        }

    }
}