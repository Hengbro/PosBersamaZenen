package com.sarumah.posbersama.ui.auth

import androidx.lifecycle.*
import com.sarumah.posbersama.core.repo.AuthRepository
import com.sarumah.posbersama.core.source.remote.request.LoginRequest

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    fun login(data: LoginRequest) = repository.login(data).asLiveData()

}