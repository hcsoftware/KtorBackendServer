package com.xr6software.backend.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.xr6software.backend.R
import com.xr6software.backend.model.Dog

class AdapterDogList(private val context : Context, private val clickListener: AdapterClickListener) : RecyclerView.Adapter<AdapterDogList.ViewHolder>() {

    private val dogList = ArrayList<Dog>()

    fun updateDataOnView(dogs: ArrayList<Dog>) {
        dogList.clear()
        dogList.addAll(dogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dog = dogList[position]
        var value = context.getString(R.string.dog_item_name) + " "+ dog.name
        holder.dogName.text = value
        value = context.getString(R.string.dog_item_age) + " " + dog.age
        holder.dogAge.text = value
        value = context.getString(R.string.dog_item_breed) + " " + dog.breed
        holder.dogBreed.text = value
        holder.dogImg.load(dog.img){
            error(com.google.android.material.R.drawable.mtrl_ic_error)
        }
        holder.itemView.setOnClickListener {
            clickListener.onClick(dog)
        }

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