package com.sarumah.posbersama.core.di

import com.sarumah.posbersama.core.repo.AuthRepository
import com.sarumah.posbersama.core.repo.CategoryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AuthRepository(get(), get()) }
    single { CategoryRepository(get(), get()) }
}
