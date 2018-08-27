package com.traveltab.wifitest.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.traveltab.wifitest.R
import com.traveltab.wifitest.action.creator.WifiActionCreator
import com.traveltab.wifitest.model.WifiAuthModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val wifiActionCreator: WifiActionCreator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectBtn.setOnClickListener { connectToDefaultWifi() }
    }

    private fun connectToDefaultWifi() {

        wifiActionCreator.enableWifi(true)

        wifiActionCreator.connectWifi(WifiAuthModel(SSID, PASS))
    }

    companion object {
        const val SSID = """"NETGEAR45""""
        const val PASS = """"rockycello888""""
    }
}
