package com.traveltab.wifitest.store

import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import com.ptmr3.fluxx.FluxxAction
import com.ptmr3.fluxx.FluxxStore
import com.ptmr3.fluxx.annotation.Action
import com.traveltab.wifitest.action.ActionDataKeys
import com.traveltab.wifitest.action.WifiActions
import com.traveltab.wifitest.model.WifiAuthModel

/**
 * Store to implement WIFI actions
 * @author Darien
 */
class WifiStore(private val wifiManager: WifiManager) : FluxxStore() {

    @Action(actionType = WifiActions.ACTION_ENABLE_WIFI)
    fun enableWifi(action: FluxxAction) {
        val enableWifi : Boolean = action[ActionDataKeys.ENABLE_WIFI_DATA_KEY]

        if (wifiManager.isWifiEnabled != enableWifi) {
            wifiManager.isWifiEnabled = enableWifi
        }
    }

    @Action(actionType = WifiActions.ACTION_CONNECT_WIFI)
    fun connectWifi(action: FluxxAction) {
        val authModel: WifiAuthModel = action[ActionDataKeys.AUTH_MODEL_DATA_KEY]

        val wifiConf = WifiConfiguration()
        wifiConf.SSID = authModel.ssid
        wifiConf.preSharedKey = authModel.pass

        val netId = wifiManager.addNetwork(wifiConf)

        wifiManager.disconnect()
        wifiManager.enableNetwork(netId, true)
        wifiManager.reconnect()
    }
}