package com.example.carfaxdemo.bootstrap

import com.example.carfaxdemo.Constants.IO_SCHEDULER
import com.example.carfaxdemo.Constants.UI_SCHEDULER
import com.example.carfaxdemo.persistence.VehicleListingDao
import com.example.carfaxdemo.remote.VehicleListingModelMapper
import com.example.carfaxdemo.remote.VehicleListingService
import com.example.carfaxdemo.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun getRepository(
        vehicleListingService: VehicleListingService,
        @Named(IO_SCHEDULER) bgScheduler: Scheduler,
        @Named(UI_SCHEDULER) uiScheduler: Scheduler,
        vehicleListingModelMapper: VehicleListingModelMapper,
        vehicleListingDao: VehicleListingDao
    ): Repository {
        return Repository(vehicleListingService, bgScheduler, uiScheduler, vehicleListingModelMapper, vehicleListingDao)
    }
}