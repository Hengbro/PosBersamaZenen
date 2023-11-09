package com.sarumah.posbersama.ui.menu.listmenu.menudiscount

import androidx.lifecycle.*
import com.sarumah.posbersama.core.repo.AuthRepository
import com.sarumah.posbersama.core.repo.CategoryRepository
import com.sarumah.posbersama.core.repo.DiscountRepository
import com.sarumah.posbersama.core.source.local.entity.CategoryEntity
import com.sarumah.posbersama.core.source.remote.request.CategoryRequest
import com.sarumah.posbersama.core.source.remote.request.DiscountRequest
import com.sarumah.posbersama.core.source.remote.request.LoginRequest

class DiscountViewModel(private val repository: DiscountRepository) : ViewModel() {

    fun getLocal() = repository.getLocal().asLiveData()
    fun get() = repository.get().asLiveData()
    fun createFix(request: DiscountRequest) = repository.createFix(request).asLiveData()
    fun createPre(request: DiscountRequest) = repository.createPre(request).asLiveData()
}