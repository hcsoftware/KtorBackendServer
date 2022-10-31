package com.xr6software.backend.server

import android.content.Context
import android.os.PowerManager
import com.xr6software.backend.model.Dog
import com.xr6software.backend.model.ResponseModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.requestHandler(context: Context) {

    val dogService by inject<DogService>()

    get(path = "/dog") {

        call.respond(ResponseModel
            (data = dogService.dogList(),
            statusCode = HttpStatusCode.Accepted)
        )
        startScreenOnRequest(context.applicationContext)

    }

    put(path = "/dog") {
        val dog = call.receive<Dog>()
            call.respond(ResponseModel(
                data = dogService.insertDog(dog),
                statusCode = HttpStatusCode.Accepted
            )
        )
        startScreenOnRequest(context.applicationContext)
    }

    delete(path = "/dog/{id}") {
        val dogId = call.parameters["id"]?.toInt()
        call.respond(ResponseModel(
            data = dogService.removeDog(dogId ?: 1),
            statusCode = HttpStatusCode.Accepted
        ))
        startScreenOnRequest(context.applicationContext)
    }

}

private fun startScreenOnRequest(context: Context) {

    val powerManager : PowerManager = context.applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
    if (!powerManager.isInteractive) {
        powerManager.newWakeLock(
            PowerManager.LOCATION_MODE_ALL_DISABLED_WHEN_SCREEN_OFF or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "Ktor::WakeScreenLock"
        ).acquire(3000)
    }

}












