package com.xr6software.backend.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.xr6software.backend.R
import com.xr6software.backend.databinding.ActivityMainBinding
import com.xr6software.backend.model.Dog
import com.xr6software.backend.repositories.DogRepository
import com.xr6software.backend.server.ServerManager
import com.xr6software.backend.utils.getServerInfo
import com.xr6software.backend.view.adapter.AdapterClickListener
import com.xr6software.backend.view.adapter.AdapterDogList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MainActivity : AppCompatActivity(), AdapterClickListener, KoinComponent {

    private lateinit var viewBinding : ActivityMainBinding
    private val dogRepository : DogRepository by inject()

    private lateinit var adapterDogList : AdapterDogList
    private lateinit var dogDialog: DogInfoDialog

    private val serverManager: ServerManager by lazy {
        ServerManager()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        dogDialog= DogInfoDialog(this)
        adapterDogList = AdapterDogList(this.applicationContext, this)

        viewBinding.maDogsItemList.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = adapterDogList
        }

        setOnClickListeners()
        setObservers()

    }

    private fun setObservers() {

        dogRepository.getDogList().observe(this) { dogList ->
            adapterDogList.updateDataOnView(dogList)
        }

        serverManager.getServerStatus().observe(this) { serverEnabled ->
            if (serverEnabled) {
                viewBinding.maButtonServerSwitch.text = getString(R.string.ma_btn_server_enabled)
                viewBinding.maTextServerInfo.text = getString(R.string.ma_server_info)+ " " + applicationContext.getServerInfo()
                viewBinding.maTextServerMethods.visibility = View.VISIBLE
                viewBinding.maTextServerInfo.visibility = View.VISIBLE
            } else {
                viewBinding.maButtonServerSwitch.text = getString(R.string.ma_btn_server_disabled)
                viewBinding.maTextServerInfo.visibility = View.GONE
                viewBinding.maTextServerMethods.visibility = View.GONE
            }
        }
    }


    private fun setOnClickListeners(){
        viewBinding.maButtonServerSwitch.setOnClickListener {
            serverManager.serverStatusSwitch(applicationContext)
        }
    }

    override fun onClick(dog: Dog) {
        dogDialog.showDialog(dog)
    }

}