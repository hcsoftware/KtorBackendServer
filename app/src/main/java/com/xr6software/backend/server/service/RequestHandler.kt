package com.xr6software.backend.server.service

import android.content.Context
import android.os.PowerManager
import com.xr6software.backend.di.modules.DogModule
import com.xr6software.backend.model.Dog
import com.xr6software.backend.server.model.ResponseModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.requestHandler(context: Context) {

    val dogModule by inject<DogModule>()

    put(path = "/init") {

        startScreenOnRequest(context.applicationContext)
        dogModule.initDogArray()
        call.respond(
            ResponseModel(
                data = "New dogs available.",
                statusCode = HttpStatusCode.Accepted
            )
        )

    }

    get(path = "/dog") {

        startScreenOnRequest(context.applicationContext)

        var responseData : Any? = if (dogModule.dogList().isNullOrEmpty()) {
            "No dogs in server."
        } else {
            dogModule.dogList()
        }

        call.respond(ResponseModel
            (data = responseData,
            statusCode = HttpStatusCode.Accepted)
        )

    }

    put(path = "/dog") {

        startScreenOnRequest(context.applicationContext)
        val dog = call.receive<Dog>()
        dogModule.insertDog(dog)
        call.respond(ResponseModel(
                data = dog,
                statusCode = HttpStatusCode.Accepted
        ))

    }

    delete(path = "/dog/id={id}") {
        startScreenOnRequest(context.applicationContext)

        val dogId = call.parameters["id"]?.toInt()
        call.respond(ResponseModel(
            data = dogModule.removeDog(dogId ?: 1),
            statusCode = HttpStatusCode.Accepted
        ))
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












