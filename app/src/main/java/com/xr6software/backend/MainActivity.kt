package com.xr6software.backend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.xr6software.backend.databinding.ActivityMainBinding
import com.xr6software.backend.server.ServerManager

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding
    //private lateinit var viewModel : ViewModel
    private val serverManager: ServerManager by lazy {
        ServerManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setOnClickListeners()
        setObservers()

    }

    /*
     *
     *

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setLoginDetails(status: Boolean) {

        if (status) {
            val wifiManager: WifiManager =
                applicationContext?.getSystemService(WIFI_SERVICE) as WifiManager
            viewBinding.maTextIp.text =
                Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)+":"+HttpService.portNumber +
                        "\n TOKEN: " + TokenGenerator.generateToken(applicationContext)
        } else {
            viewBinding.maTextIp.text = "The service is disabled"
        }
    }
     */

    private fun setObservers() {
        serverManager.getServerStatus().observe(this, {
            if (it) {
                viewBinding.maTextServerInfo.text = "Server Enabled"
            } else {
                viewBinding.maTextServerInfo.text = "Server Disabled"
            }
        })
    }

    private fun setOnClickListeners(){
        viewBinding.maButtonServerSwitch.setOnClickListener {
            serverManager.serverStatusSwitch(applicationContext)
        }
    }

}