package com.sarumah.posbersama.core.repo

import com.sarumah.posbersama.core.source.local.LocalDataSource
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.model.User
import com.sarumah.posbersama.core.source.remote.network.ApiService
import com.sarumah.posbersama.core.source.remote.network.ResponseHandler
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.core.source.remote.response.base.DataResponse
import com.sarumah.posbersama.core.source.remote.response.base.ListResponse
import com.sarumah.posbersama.util.Prefs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class CategoryRepository(val local: LocalDataSource, val remote: ApiService) {

    fun get() = object : ResponseHandler<List<CategoryEntity>, ListResponse<CategoryEntity>>() {
        override suspend fun createCall(): Response<ListResponse<CategoryEntity>> {
            return remote.getCategory()
        }

        override suspend fun resultCall(data: ListResponse<CategoryEntity>): List<CategoryEntity> {
            return data.data
        }
    }.asFlow().flowOn(Dispatchers.IO)

    fun create(request: CategoryRequest) =
        object : ResponseHandler<CategoryEntity, DataResponse<CategoryEntity>>() {
            override suspend fun createCall(): Response<DataResponse<CategoryEntity>> {
                return remote.createCategory(request)
            }

            override suspend fun resultCall(data: DataResponse<CategoryEntity>): CategoryEntity {
                return data.data ?: CategoryEntity()
            }
        }.asFlow().flowOn(Dispatchers.IO)

    fun update(request: CategoryRequest) =
        object : ResponseHandler<CategoryEntity, DataResponse<CategoryEntity>>() {
            override suspend fun createCall(): Response<DataResponse<CategoryEntity>> {
                return remote.updateCategory(request.id, request)
            }

            override suspend fun resultCall(data: DataResponse<CategoryEntity>): CategoryEntity {
                return data.data ?: CategoryEntity()
            }
        }.asFlow().flowOn(Dispatchers.IO)

    fun delete(data: CategoryEntity) =
        object : ResponseHandler<CategoryEntity, DataResponse<CategoryEntity>>() {
            override suspend fun createCall(): Response<DataResponse<CategoryEntity>> {
                return remote.deleteCategory(data.id)
            }

            override suspend fun resultCall(data: DataResponse<CategoryEntity>): CategoryEntity {
                return data.data ?: CategoryEntity()
            }
        }.asFlow().flowOn(Dispatchers.IO)

}