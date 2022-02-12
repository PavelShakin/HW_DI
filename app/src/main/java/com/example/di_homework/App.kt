package com.example.di_homework

import android.app.Application
import com.example.di_homework.di.ModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(ModuleList)
        }
    }
}