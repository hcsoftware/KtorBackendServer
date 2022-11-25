package com.xr6software.backend

import android.app.Application
import com.xr6software.backend.repositories.DogRepository
import com.xr6software.backend.repositories.DogRepositoryImp
import com.xr6software.backend.server.DogService
import org.koin.core.context.startKoin
import org.koin.dsl.module


class BackendApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    single<DogRepository> { DogRepositoryImp() }
                    single { DogService() }
                }
            )
        }
    }

}