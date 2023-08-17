package com.xr6software.backend.server.model

import io.ktor.http.*

data class ResponseModel<T> (
    val statusCode: HttpStatusCode = HttpStatusCode.Accepted,
    val data: T? = null
    )