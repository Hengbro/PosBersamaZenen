package com.sarumah.posbersama.ui.category

import androidx.lifecycle.*
import com.sarumah.posbersama.core.repo.AuthRepository
import com.sarumah.posbersama.core.repo.CategoryRepository
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    fun getLocal() = repository.getLocal().asLiveData()
    fun get() = repository.get().asLiveData()
    fun create(request: CategoryRequest) = repository.create(request).asLiveData()
    fun update(request: CategoryRequest) = repository.update(request).asLiveData()
    fun delete(data: CategoryEntity) = repository.delete(data).asLiveData()
}