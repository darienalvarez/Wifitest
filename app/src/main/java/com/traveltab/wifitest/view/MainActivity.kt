package com.traveltab.wifitest.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.traveltab.wifitest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectBtn.setOnClickListener { connectToDefaultWifi() }
    }

    private fun connectToDefaultWifi() {

    }
}
