package com.xr6software.backend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xr6software.backend.model.Dog
import com.xr6software.backend.repositories.DogRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

class MainActivityViewModel : ViewModel(), KoinComponent {

    private val dogListServer : MutableLiveData<ArrayList<Dog>> =  MutableLiveData<ArrayList<Dog>>()

    private val dogRepository by inject<DogRepository>()

    fun updateDogList() {

        dogListServer.value = dogRepository.dogList()

    }

    fun getDogList() : LiveData<ArrayList<Dog>> {

        return dogListServer

    }



}