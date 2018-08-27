package com.traveltab.wifitest.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ptmr3.fluxx.FluxxReaction
import com.ptmr3.fluxx.FluxxReactionSubscriber
import com.ptmr3.fluxx.annotation.Reaction
import com.traveltab.wifitest.R
import com.traveltab.wifitest.action.ActionDataKeys
import com.traveltab.wifitest.action.WifiActions
import com.traveltab.wifitest.action.creator.WifiActionCreator
import com.traveltab.wifitest.model.WifiAuthModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), FluxxReactionSubscriber {

    private val wifiActionCreator: WifiActionCreator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReactionSubscriber(this)
        setContentView(R.layout.activity_main)

        connectBtn.setOnClickListener { wifiActionCreator.enableWifi(true) }
    }

    override fun onDestroy() {
        unregisterReactionSubscriber(this)
        super.onDestroy()
    }

    @Reaction(WifiActions.ACTION_ENABLE_WIFI)
    fun enablingWifiReaction(reaction: FluxxReaction) {
        if (reaction[ActionDataKeys.ENABLING_WIFI_DATA_KEY]) {
            Toast.makeText(this, "Enabling wifi", Toast.LENGTH_LONG).show()
        }

        wifiActionCreator.connectWifi(WifiAuthModel(SSID, PASS))
    }

    @Reaction(WifiActions.ACTION_CONNECT_WIFI)
    fun connectingWifiReaction(reaction: FluxxReaction) {
        Toast.makeText(this, "Connecting to the default wifi", Toast.LENGTH_LONG).show()
    }

    companion object {
        const val SSID = """"TravelTab""""
        const val PASS = """"123456789""""
    }
}
