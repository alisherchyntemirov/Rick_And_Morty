package com.example.rick_and_morty

import android.app.Application
import com.example.rick_and_morty.servicelocatior.networkModule
import com.example.rick_and_morty.servicelocatior.repositoriesModule
import com.example.rick_and_morty.servicelocatior.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, repositoriesModule, viewModelsModule)
        }
    }
}