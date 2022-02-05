package com.example.carfaxdemo.repository

import com.example.carfaxdemo.remote.VehicleListingModelMapper
import com.example.carfaxdemo.remote.VehicleListingService
import io.reactivex.rxjava3.core.Scheduler

class Repository (
    private val vehicleListingService: VehicleListingService,
    private val bgScheduler: Scheduler,
    private val uiScheduler: Scheduler,
    private val vehicleListingModelMapper: VehicleListingModelMapper
) {
    private val tag = Repository::class.java.simpleName

}