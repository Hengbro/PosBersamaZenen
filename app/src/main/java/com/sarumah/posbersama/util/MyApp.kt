package com.sarumah.posbersama.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.inyongtisto.myhelper.extension.logs
import com.sarumah.posbersama.core.di.appModule
import com.sarumah.posbersama.core.di.repositoryModule
import com.sarumah.posbersama.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // shared Pref
        Kotpref.init(this)

        // koin dependency injection
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}