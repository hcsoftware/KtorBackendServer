package com.xr6software.backend.view.adapter

import com.xr6software.backend.model.Dog

interface AdapterClickListener {
    fun onClick(dog: Dog)
}