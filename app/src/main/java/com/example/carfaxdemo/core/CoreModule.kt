package com.example.carfaxdemo.core

import com.example.carfaxdemo.Constants.Companion.IO_SCHEDULER
import com.example.carfaxdemo.Constants.Companion.UI_SCHEDULER
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {

    @Singleton
    @Provides
    @Named(IO_SCHEDULER)
    fun getIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Singleton
    @Provides
    @Named(UI_SCHEDULER)
    fun getUiScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}