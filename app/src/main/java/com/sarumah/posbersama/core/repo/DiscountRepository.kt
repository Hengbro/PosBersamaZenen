package com.sarumah.posbersama.core.repo

import com.sarumah.posbersama.core.source.local.AppDatabase
import com.sarumah.posbersama.core.source.local.LocalDataSource
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.local.entity.DiscountEntity
import com.sarumah.posbersama.core.source.model.User
import com.sarumah.posbersama.core.source.remote.network.ApiService
import com.sarumah.posbersama.core.source.remote.network.ResponseHandler
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.DiscountRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.core.source.remote.response.base.DataResponse
import com.sarumah.posbersama.core.source.remote.response.base.ListResponse
import com.sarumah.posbersama.util.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class DiscountRepository(val local: AppDatabase, val remote: ApiService) {

    private fun dao() = local.dicountDao()
    fun getLocal() = local.dicountDao().getAll()

    fun get() = object : ResponseHandler<List<DiscountEntity>, ListResponse<DiscountEntity>>() {
        override suspend fun createCall(): Response<ListResponse<DiscountEntity>> {
            return remote.getDiscount()
        }

        override suspend fun resultCall(data: ListResponse<DiscountEntity>): List<DiscountEntity> {
            val response = data.data
            dao().insert(response)
            return response
        }
    }.asFlow().flowOn(Dispatchers.IO)

    fun createFix(request: DiscountRequest) =
        object : ResponseHandler<DiscountEntity, DataResponse<DiscountEntity>>() {
            override suspend fun createCall(): Response<DataResponse<DiscountEntity>> {
                return remote.createDiscountfix(request)
            }

            override suspend fun resultCall(data: DataResponse<DiscountEntity>): DiscountEntity{
                val response = data.data ?: DiscountEntity()
                dao().insert(response)
                return response
            }
        }.asFlow().flowOn(Dispatchers.IO)

    fun createPre(request: DiscountRequest) =
        object : ResponseHandler<DiscountEntity, DataResponse<DiscountEntity>>() {
            override suspend fun createCall(): Response<DataResponse<DiscountEntity>> {
                return remote.createDiscountfix(request)
            }

            override suspend fun resultCall(data: DataResponse<DiscountEntity>): DiscountEntity{
                val response = data.data ?: DiscountEntity()
                dao().insert(response)
                return response
            }
        }.asFlow().flowOn(Dispatchers.IO)

}