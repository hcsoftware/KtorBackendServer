package com.xr6software.backend.repositories

import com.xr6software.backend.model.Dog

interface DogRepository {

    fun dogList(): ArrayList<Dog>
    fun addDog(dog: Dog): Dog
    fun removeDog(dog: Dog) : Dog

}

class DogRepositoryImp : DogRepository {

    private var dogIndex = 0
    private val dogList = ArrayList<Dog>()

    override fun addDog(dog: Dog): Dog {
        val newDog = dog.copy(id = ++dogIndex)
        dogList.add(newDog)
        return newDog
    }

    override fun removeDog(dog: Dog): Dog {
        dogList.remove(dog)
        return dog
    }

    override fun dogList(): ArrayList<Dog> = dogList

}