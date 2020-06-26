package com.formationandroid.kotlin

import android.app.Application
import com.formationandroid.kotlin.module.AppModule
import com.formationandroid.kotlin.repository.MainRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(mainRepository: MainRepository)
}