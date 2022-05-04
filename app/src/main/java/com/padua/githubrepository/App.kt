package com.padua.githubrepository

import android.app.Application
import android.app.Presentation
import com.padua.githubrepository.data.di.DataModule
import com.padua.githubrepository.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        PresentationModule.load()
        DataModule.load()
    }
}