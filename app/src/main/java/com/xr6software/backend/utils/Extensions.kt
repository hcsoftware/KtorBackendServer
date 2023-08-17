package com.xr6software.backend.utils

import android.content.Context
import android.net.wifi.WifiManager
import android.text.format.Formatter
import androidx.appcompat.app.AppCompatActivity
import com.xr6software.backend.server.service.HttpService

fun Context.getServerInfo() : String {

    val wifiManager: WifiManager = this.getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager
    return Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)+":"+ HttpService.SERVER_PORT

}