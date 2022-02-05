package com.example.carfaxdemo.bootstrap

import com.example.carfaxdemo.Constants
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
        @Named(Constants.IO_SCHEDULER) bgScheduler: Scheduler,
        @Named(Constants.UI_SCHEDULER) uiScheduler: Scheduler,
        vehicleListingModelMapper: VehicleListingModelMapper
    ): Repository {
        return Repository(vehicleListingService, bgScheduler, uiScheduler, vehicleListingModelMapper)
    }
}