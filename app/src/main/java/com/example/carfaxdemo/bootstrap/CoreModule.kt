package com.example.carfaxdemo.bootstrap

import com.example.carfaxdemo.Constants.BASE_API_URL
import com.example.carfaxdemo.Constants.IO_SCHEDULER
import com.example.carfaxdemo.Constants.UI_SCHEDULER
import com.example.carfaxdemo.remote.VehicleListingModelMapper
import com.example.carfaxdemo.remote.VehicleListingService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

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

    @Singleton
    @Provides
    fun getVehicleListingService(): VehicleListingService {
        return Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(VehicleListingService::class.java)
    }

    @Singleton
    @Provides
    fun getVehicleListingModelMapper(): VehicleListingModelMapper {
        return VehicleListingModelMapper()
    }
}