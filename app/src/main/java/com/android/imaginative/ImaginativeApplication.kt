package com.android.imaginative

import android.app.Application
import android.content.Context

class ImaginativeApplication: Application() {

    companion object {
        lateinit var context: Context //全局上下文
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}