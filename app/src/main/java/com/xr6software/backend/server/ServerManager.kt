package com.xr6software.backend.server

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xr6software.backend.server.service.HttpService

class ServerManager : ViewModel() {

    private var serverStatus = MutableLiveData<Boolean>(false)

    private fun getKtorServerStatus(context: Context) : Boolean {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (HttpService::class.java.name == service.service.className) {
                return true
            }
        }
        return false
    }

    private fun startKtorServer(context: Context) {
        context.startService(Intent(context, HttpService::class.java))
    }

    private fun stopKtorServer(context: Context) {
        context.stopService(Intent(context, HttpService::class.java))
    }

    fun serverStatusSwitch(context: Context) {
        if (!getKtorServerStatus(context)) {startKtorServer(context); serverStatus.value = true}
        else {stopKtorServer(context); serverStatus.value = false}
    }

    fun getServerStatus() : LiveData<Boolean> {
        return serverStatus
    }

}