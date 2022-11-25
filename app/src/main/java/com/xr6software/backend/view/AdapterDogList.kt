package com.xr6software.backend.view

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.xr6software.backend.R
import com.xr6software.backend.model.Dog
import com.xr6software.backend.model.DogViewHolderItem
import com.xr6software.backend.model.toDogViewHolderItem

class AdapterDogList(val context : Context) : RecyclerView.Adapter<AdapterDogList.ViewHolder>() {

    private val dogList = ArrayList<Dog>()

    fun updateDataOnView(dogs: ArrayList<Dog>) {
        dogList.clear()
        dogList.addAll(dogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return AdapterDogList.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dog : DogViewHolderItem = dogList[position].toDogViewHolderItem()
        holder.dogName.text =  context.getString(R.string.dog_item_name) + " "+ dog.name
        holder.dogAge.text = context.getString(R.string.dog_item_age) + " " + dog.age
        holder.dogBreed.text = context.getString(R.string.dog_item_breed) + " " + dog.breed
        holder.dogImg.load(dog.img)

    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        val dogName : TextView = v.findViewById(R.id.item_dog_txt_name)
        val dogBreed : TextView = v.findViewById(R.id.item_dog_txt_breed)
        val dogAge : TextView = v.findViewById(R.id.item_dog_txt_age)
        val dogImg : ImageView = v.findViewById(R.id.item_dog_img)

    }
}