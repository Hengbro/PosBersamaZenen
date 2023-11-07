package com.sarumah.posbersama.core.source.remote.request.base

data class DataResponse<T>(
        var message: String = "",
        var code: String = "",
        var data: T? = null
)