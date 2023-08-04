package com.xr6software.backend.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xr6software.backend.model.Dog


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

    override fun removeDog(dogId: Int): Dog {
        dogList.forEach {
            if (it.id == dogId) {
                dogListLiveData.postValue(dogList)
                dogList.remove(it)
                return it
            }
        }
        return Dog(0,"",0,"","")
    }

    override fun getDogList(): LiveData<ArrayList<Dog>> {
        return dogListLiveData
    }

    override fun initDogArray() {

        dogList.addAll(randomDogs)
        dogListLiveData.postValue(dogList)

    }

    private val randomDogs : List<Dog> = listOf<Dog>(
        Dog(
            ++dogIndex,
            "Milo",
            1,
            "Border Collie",
            "https://soyunperro.com/wp-content/uploads/2018/01/Border-Collie-de-ojos-azules-770x470.jpg"
        ),
        Dog(
            ++dogIndex,
            "Harry",
            8,
            "Golden Retrievers",
            "https://www.elespectador.com/resizer/vZk5i6lSDUXdySfFk9ZAKNIPA2Y=/657x0/filters:format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/T2REW657GVA7RNQMDTDLMFZ6TM.jpg"
        ),
        Dog(
            ++dogIndex,
            "Indy",
            9,
            "Brittany ",
            "https://www.akc.org/wp-content/uploads/2017/11/Brittany-1.jpg"
        ),
        Dog(
            ++dogIndex,
            "Jhonny B. Dog",
            9,
            "Bulldog ",
            "https://cdn.pixabay.com/photo/2020/07/20/06/42/english-bulldog-5422018__340.jpg"
        )
    )

}