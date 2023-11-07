package com.sarumah.posbersama.core.source.remote.network

import com.sarumah.posbersama.core.source.model.User
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.core.source.remote.request.base.DataResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body user: LoginRequest
    ): Response<DataResponse<User>>

}