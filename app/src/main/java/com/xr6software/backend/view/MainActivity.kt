package com.xr6software.backend.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.xr6software.backend.R
import com.xr6software.backend.databinding.ActivityMainBinding
import com.xr6software.backend.repositories.DogRepository
import com.xr6software.backend.server.ServerManager
import com.xr6software.backend.utils.getServerInfo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MainActivity : AppCompatActivity(), KoinComponent {

    private lateinit var viewBinding : ActivityMainBinding
    private val dogRepository : DogRepository by inject()

    private lateinit var adapterDogList : AdapterDogList

    private val serverManager: ServerManager by lazy {
        ServerManager()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        adapterDogList = AdapterDogList(this.applicationContext)

        viewBinding.maDogsItemList.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = adapterDogList
        }

        setOnClickListeners()
        setObservers()

    }

    private fun setObservers() {

        dogRepository.getDogList().observe(this) {
            adapterDogList.updateDataOnView(it)
        }

        serverManager.getServerStatus().observe(this) {
            if (it) {
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

}