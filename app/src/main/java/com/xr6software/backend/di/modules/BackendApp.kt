package com.xr6software.backend.di.modules

import android.app.Application
import com.xr6software.backend.repositories.DogRepository
import com.xr6software.backend.repositories.DogRepositoryImp
import org.koin.core.context.startKoin
import org.koin.dsl.module


class BackendApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    single<DogRepository> { DogRepositoryImp() }
                    single<DogModule> { DogModule() }
                }
            )
        }
    }

}