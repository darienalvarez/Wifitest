package com.traveltab.wifitest.action

import com.traveltab.wifitest.model.WifiAuthModel

/**
 * Definition of WIFI actions
 *
 * @author Darien
 */
interface WifiActions {

    /**
     * Enable the wifi is is disabled
     */
    fun enableWifi(param: Boolean)

    /**
     * Connect to a wifi with the provided auth model
     *
     * @param param the wifi auth model [WifiAuthModel]
     */
    fun connectWifi(param: WifiAuthModel)

    companion object {
        const val ACTION_ENABLE_WIFI = "action_enable_wifi"
        const val ACTION_CONNECT_WIFI = "action_connect_wifi"
    }

}