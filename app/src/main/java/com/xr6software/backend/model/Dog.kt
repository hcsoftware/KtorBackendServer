package com.xr6software.backend.model

import java.io.Serializable

data class Dog (
    val id : Int?,
    val name : String,
    val age: Int,
    val breed: String,
    val img : String?
    ) : Serializable

data class DogViewHolderItem (
    val name : String,
    val age: Int,
    val breed: String,
    val img : String
)

fun Dog.toDogViewHolderItem() = DogViewHolderItem(
    name,
    age,
    breed,
    img ?: "https://images.pexels.com/photos/406014/pexels-photo-406014.jpeg?auto=compress&cs=tinysrgb&w=600"
)