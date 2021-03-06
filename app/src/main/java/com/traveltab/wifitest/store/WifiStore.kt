package com.traveltab.wifitest.store

import android.content.Context
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import com.ptmr3.fluxx.FluxxAction
import com.ptmr3.fluxx.FluxxStore
import com.ptmr3.fluxx.annotation.Action
import com.traveltab.wifitest.action.ActionDataKeys.AUTH_MODEL_DATA_KEY
import com.traveltab.wifitest.action.ActionDataKeys.CONNECTING_WIFI_DATA_KEY
import com.traveltab.wifitest.action.ActionDataKeys.ENABLE_WIFI_DATA_KEY
import com.traveltab.wifitest.action.ActionDataKeys.ENABLING_WIFI_DATA_KEY
import com.traveltab.wifitest.action.WifiActions.Companion.ACTION_CONNECT_WIFI
import com.traveltab.wifitest.action.WifiActions.Companion.ACTION_ENABLE_WIFI
import com.traveltab.wifitest.model.WifiAuthModel

/**
 * Store to implement WIFI actions
 * @author Darien
 */
class WifiStore(context: Context) : FluxxStore() {
    private val wifiManager: WifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

    @Action(actionType = ACTION_ENABLE_WIFI)
    fun enableWifi(action: FluxxAction) {
        val enableWifi : Boolean = action[ENABLE_WIFI_DATA_KEY]

        if (wifiManager.isWifiEnabled != enableWifi) {
            wifiManager.isWifiEnabled = enableWifi
            publishReaction(action.type, ENABLING_WIFI_DATA_KEY, true)
        } else {
            publishReaction(action.type, ENABLING_WIFI_DATA_KEY, true)
        }
    }

    @Action(actionType = ACTION_CONNECT_WIFI)
    fun connectWifi(action: FluxxAction) {
        val authModel: WifiAuthModel = action[AUTH_MODEL_DATA_KEY]

        val wifiConf = WifiConfiguration()
        wifiConf.SSID = authModel.ssid
        wifiConf.preSharedKey = authModel.pass

        val netId = wifiManager.addNetwork(wifiConf)

        wifiManager.disconnect()
        wifiManager.enableNetwork(netId, true)
        wifiManager.reconnect()

        publishReaction(action.type, CONNECTING_WIFI_DATA_KEY, true)
    }
}