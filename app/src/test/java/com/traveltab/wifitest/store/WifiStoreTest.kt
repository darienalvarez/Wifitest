package com.traveltab.wifitest.store

import android.content.Context
import android.net.wifi.WifiManager
import com.ptmr3.fluxx.FluxxAction
import com.traveltab.wifitest.action.ActionDataKeys
import com.traveltab.wifitest.action.WifiActions
import com.traveltab.wifitest.model.WifiAuthModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * @author Darien
 */
@RunWith(MockitoJUnitRunner::class)
class WifiStoreTest {

    private lateinit var wifiManager: WifiManager
    private lateinit var wifiStore: WifiStore

    @Before
    fun setup() {

        wifiManager = Mockito.mock(WifiManager::class.java)

        val context: Context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.getSystemService(Context.WIFI_SERVICE)).thenReturn(wifiManager)

        wifiStore = WifiStore(context)
    }

    @Test
    fun test_enableWifi_connectWifi_was_called() {

        val action = FluxxAction
                .type(WifiActions.ACTION_ENABLE_WIFI)
                .bundle(ActionDataKeys.AUTH_MODEL_DATA_KEY, WifiAuthModel("ssid", "pass"))
                .build()

        wifiStore.connectWifi(action)

        Mockito.verify(wifiManager).addNetwork(Mockito.any())
    }
}