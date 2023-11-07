package com.sarumah.posbersama.core.repo

import com.sarumah.posbersama.core.source.local.LocalDataSource
import com.sarumah.posbersama.core.source.model.User
import com.sarumah.posbersama.core.source.remote.network.ApiService
import com.sarumah.posbersama.core.source.remote.network.ResponseHandler
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.core.source.remote.request.base.DataResponse
import com.sarumah.posbersama.util.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class AuthRepository(val local: LocalDataSource, val remote: ApiService) {

    fun login(mData: LoginRequest) = object : ResponseHandler<User, DataResponse<User>>() {
        override suspend fun createCall(): Response<DataResponse<User>> {
            return remote.login(mData)
        }

        override suspend fun resultCall(data: DataResponse<User>): User {
            val user = data.data ?: User()
            Prefs.isLogin = true
            Prefs.token = user.token
            return user
        }
    }.asFlow().flowOn(Dispatchers.IO)

}