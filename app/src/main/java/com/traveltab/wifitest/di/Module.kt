package com.traveltab.wifitest.di

import android.content.Context
import com.traveltab.wifitest.action.creator.WifiActionCreator
import com.traveltab.wifitest.store.WifiStore
import org.koin.dsl.module.module

/**
 * Dependency injection definitions
 *
 * @author Darien
 */
class Module(context: Context) {

    private val actionsCreatorsModule = module {
        single(createOnStart = true) { WifiActionCreator() }
    }

    private val storeModule = module {
        single(createOnStart = true) { WifiStore(context) }
    }

    val modules = listOf(actionsCreatorsModule, storeModule)
}