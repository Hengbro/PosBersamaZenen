package com.sarumah.posbersama.core.di

import androidx.room.Room
import com.sarumah.posbersama.core.source.local.AppDatabase
import com.sarumah.posbersama.core.source.local.LocalDataSource
import com.sarumah.posbersama.core.source.remote.RemoteDataSource
import com.sarumah.posbersama.core.source.remote.network.ApiConfig
import com.sarumah.posbersama.util.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                Constants.DB_NAME
        ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    single { ApiConfig.provideApiService }

    single { LocalDataSource(get()) }

    single { RemoteDataSource(get()) }

}