package com.sarumah.posbersama.core.di

import com.sarumah.posbersama.ui.auth.AuthViewModel
import com.sarumah.posbersama.ui.menu.listmenu.menudiscount.DiscountViewModel
import com.sarumah.posbersama.ui.menu.listmenu.productinventory.categories.CategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { DiscountViewModel(get()) }
}
