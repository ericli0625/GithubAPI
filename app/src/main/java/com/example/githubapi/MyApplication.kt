package com.example.githubapi

import android.app.Application
import com.example.githubapi.koin.appModule
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }

        val config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build()

        Fresco.initialize(this, config)
    }
}