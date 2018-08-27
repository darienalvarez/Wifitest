package com.traveltab.wifitest.action.creator

import com.ptmr3.fluxx.FluxxActionCreator
import com.traveltab.wifitest.action.ActionDataKeys
import com.traveltab.wifitest.action.WifiActions
import com.traveltab.wifitest.model.WifiAuthModel

/**
 * Wifi Action creator
 *
 * @author Darien
 */
class WifiActionCreator : FluxxActionCreator(), WifiActions {

    override fun enableWifi(param: Boolean) {
        publishAction(WifiActions.ACTION_ENABLE_WIFI, ActionDataKeys.ENABLE_WIFI_DATA_KEY, param)
    }

    override fun connectWifi(param: WifiAuthModel) {
        publishAction(WifiActions.ACTION_CONNECT_WIFI, ActionDataKeys.AUTH_MODEL_DATA_KEY, param)
    }

}