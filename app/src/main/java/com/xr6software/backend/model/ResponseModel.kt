package com.xr6software.backend.model

import io.ktor.http.*

data class ResponseModel<T> (
    val status: Int = 0,
    val data: T? = null,
    val statusCode: HttpStatusCode = HttpStatusCode.MethodNotAllowed
    )