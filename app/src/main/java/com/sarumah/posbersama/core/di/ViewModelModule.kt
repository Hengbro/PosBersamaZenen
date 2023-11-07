package com.sarumah.posbersama.core.di

import com.sarumah.posbersama.ui.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
//    viewModel { CategoryViewModel(get()) }
}
