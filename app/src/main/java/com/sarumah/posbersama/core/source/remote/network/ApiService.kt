package com.sarumah.posbersama.core.source.remote.network

import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.model.User
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.core.source.remote.response.base.DataResponse
import com.sarumah.posbersama.core.source.remote.response.base.ListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body user: LoginRequest
    ): Response<DataResponse<User>>


    @GET("category")
    suspend fun getCategory(): Response<ListResponse<CategoryEntity>>

    @POST("category")
    suspend fun createCategory(
        @Body data: CategoryRequest
    ): Response<DataResponse<CategoryEntity>>

    @PUT("category/{id}")
    suspend fun updateCategory(
        @Path("id") id: Int?,
        @Body data: CategoryRequest
    ): Response<DataResponse<CategoryEntity>>

    @DELETE("category/{id}")
    suspend fun deleteCategory(
        @Path("id") id: Int?
    ): Response<DataResponse<CategoryEntity>>

}