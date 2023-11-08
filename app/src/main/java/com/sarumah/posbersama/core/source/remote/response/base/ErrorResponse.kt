package com.sarumah.posbersama.core.source.remote.response.base

data class ErrorResponse(
    val code: Int? = null,
    val message: String? = null,
    val param: String? = null,
    val error: Error? = null
) {
    data class Error(
//        val error: NestedError? = null,
        val message: String? = null
    )

    data class NestedError(
        val error: String? = null,
        val message: String? = null,
        val error_code: Int? = null,
    )
}