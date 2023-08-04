package com.xr6software.backend.model

import java.io.Serializable

data class Dog (
    val id : Int?,
    val name : String,
    val age: Int,
    val breed: String,
    val img : String?
    ) : Serializable

