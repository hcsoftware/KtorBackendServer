package com.xr6software.backend.di.modules

import com.xr6software.backend.model.Dog
import com.xr6software.backend.repositories.DogRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class DogModule: KoinComponent {

    private val dogRepository by inject<DogRepository>()

    fun dogList() : ArrayList<Dog>? = dogRepository.getDogList().value

    fun removeDog(id: Int) : Dog = dogRepository.removeDog(id)

    fun insertDog(dog: Dog) = dogRepository.addDog(dog)

    fun initDogArray() = dogRepository.initDogArray()

}
