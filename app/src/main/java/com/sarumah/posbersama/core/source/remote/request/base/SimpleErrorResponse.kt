package com.sarumah.posbersama.core.source.remote.request.base

data class SimpleErrorResponse(
    val code: Int? = null,
    val message: String? = null,
    val param: String? = null,
    val error: Error? = null
) {
    data class Error(
        val error: String? = null,
        val message: String? = null
    )
}