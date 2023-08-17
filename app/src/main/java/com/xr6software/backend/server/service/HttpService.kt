package com.xr6software.backend.server.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*


class HttpService : Service() {

    companion object {
        const val SERVER_PORT = 8080
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private val server = embeddedServer(Netty, SERVER_PORT) {

        install(ContentNegotiation) {
            gson()
        }
        install(Routing) {
            requestHandler(applicationContext)
        }


    }

    override fun onCreate() {
        super.onCreate()
        server.start(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        server.stop()
    }

}