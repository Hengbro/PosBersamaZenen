package com.sarumah.posbersama.core.source.remote

import com.sarumah.posbersama.core.source.remote.network.ApiService
import com.sarumah.posbersama.core.source.remote.request.LoginRequest

class RemoteDataSource(private val api: ApiService) {
    suspend fun login(user: LoginRequest) = api.login(user)

}