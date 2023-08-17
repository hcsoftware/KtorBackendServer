package com.xr6software.backend.repositories

import androidx.lifecycle.LiveData
import com.xr6software.backend.model.Dog

interface DogRepository {

    fun addDog(dog: Dog): Dog
    fun removeDog(id: Int) : Dog
    fun getDogList() : LiveData<ArrayList<Dog>>
    fun initDogArray()

}