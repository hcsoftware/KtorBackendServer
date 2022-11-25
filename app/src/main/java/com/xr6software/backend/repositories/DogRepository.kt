package com.xr6software.backend.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xr6software.backend.model.Dog

interface DogRepository {

    fun dogList(): ArrayList<Dog>
    fun addDog(dog: Dog): Dog
    fun removeDog(dog: Dog) : Dog
    fun getDogList() : LiveData<ArrayList<Dog>>
    fun initDogArray()

}

class DogRepositoryImp : DogRepository {

    private var dogListLiveData = MutableLiveData<ArrayList<Dog>>()
    private var dogIndex = 0
    private val dogList = ArrayList<Dog>()

    override fun addDog(dog: Dog): Dog {
        val newDog = dog.copy(id = ++dogIndex)
        dogList.add(newDog)
        dogListLiveData.postValue(dogList)

        return newDog
    }

    override fun removeDog(dog: Dog): Dog {
        dogList.remove(dog)
        dogListLiveData.postValue(dogList)

        return dog
    }

    override fun dogList(): ArrayList<Dog> = dogList

    override fun getDogList() : LiveData<ArrayList<Dog>> {
        return dogListLiveData
    }

    override fun initDogArray() {

        var dog = Dog(
            1,"Milo",1,"Border Collie", "https://soyunperro.com/wp-content/uploads/2018/01/Border-Collie-de-ojos-azules-770x470.jpg"
        )
        dogList.add(dog)
        dog = Dog(
            2,"Harry",8,"Golden Retrievers", "https://www.elespectador.com/resizer/vZk5i6lSDUXdySfFk9ZAKNIPA2Y=/657x0/filters:format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/T2REW657GVA7RNQMDTDLMFZ6TM.jpg"
        )
        dogList.add(dog)
        dog = Dog(
            3,"Indy",9,"Brittany ", "https://www.akc.org/wp-content/uploads/2017/11/Brittany-1.jpg"
        )
        dogList.add(dog)
        dogListLiveData.postValue(dogList)


    }

}