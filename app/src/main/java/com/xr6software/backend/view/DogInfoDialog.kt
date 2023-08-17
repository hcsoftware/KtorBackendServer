package com.xr6software.backend.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import coil.load
import com.xr6software.backend.R
import com.xr6software.backend.model.Dog

class DogInfoDialog (val context: Context) {

    var isShowing : Boolean = false

    fun showDialog(dog: Dog) {

        val builder = AlertDialog.Builder(context, androidx.appcompat.R.style.AlertDialog_AppCompat)
            .create()

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = inflater.inflate(R.layout.dialog_dog_info, null)
        val button = view.findViewById<Button>(R.id.dialog_button)
        val image = view.findViewById<ImageView>(R.id.dialog_imageView)
        val name = view.findViewById<TextView>(R.id.dialog_name)
        val details = view.findViewById<TextView>(R.id.dialog_details)

        image.load(dog.img)
        name.text = dog.name
        val detailsText = "Breed: ${dog.breed}  Age: ${dog.age}"
        details.text = detailsText

        builder.setView(view)

        button.setOnClickListener {
            builder.dismiss()
            isShowing = false
        }

        builder.setCanceledOnTouchOutside(false)
        builder.setCancelable(false)
        builder.show()
        isShowing = true
        builder.window?.setLayout(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

    }

}