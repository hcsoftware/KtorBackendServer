package com.xr6software.backend.server

import com.xr6software.backend.model.Dog
import com.xr6software.backend.repositories.DogRepository
import com.xr6software.backend.repositories.DogRepositoryImp
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DogService: KoinComponent {

    private val dogRepository by inject<DogRepository>()

    fun dogList() : List<Dog> = dogRepository.dogList()

    fun removeDog(id: Int) : Dog = dogRepository.removeDog(id as Dog)

    fun insertDog(dog: Dog) = dogRepository.addDog(dog)

    fun initDogArray() = dogRepository.initDogArray()

}