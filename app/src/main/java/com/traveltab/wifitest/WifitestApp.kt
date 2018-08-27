package com.traveltab.wifitest

import android.app.Application
import com.traveltab.wifitest.di.Module
import org.koin.android.ext.android.startKoin

/**
 * @author Darien
 */
class WifitestApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val module = Module(this)
        startKoin(this, module.modules)
    }
}