package com.traveltab.wifitest.di

import android.content.Context
import android.net.wifi.WifiManager
import com.traveltab.wifitest.action.creator.WifiActionCreator
import com.traveltab.wifitest.store.WifiStore
import org.koin.dsl.module.applicationContext

/**
 * Dependency injection definitions
 *
 * @author Darien
 */
class Module(context: Context) {

    private val actionsCreatorsModule = applicationContext {
        bean { WifiActionCreator() }
    }

    private val appModule = applicationContext {
        factory { context.getSystemService(Context.WIFI_SERVICE) } bind WifiManager::class
    }

    private val storeModule = applicationContext {
        bean { WifiStore(get()) }
    }

    val modules = listOf(actionsCreatorsModule, appModule, storeModule)
}