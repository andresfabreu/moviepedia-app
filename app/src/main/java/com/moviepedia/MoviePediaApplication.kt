package com.moviepedia

import android.app.Application
import com.moviepedia.network.networkModule
import com.moviepedia.serverDrivenUi.di.serverDrivenUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

internal class MoviePediaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MoviePediaApplication)
            modules(
                networkModule,
                serverDrivenUiModule,
            )
        }
    }
}