package com.example.carfaxdemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.example.carfaxdemo.persistence.VehicleListingDao
import com.example.carfaxdemo.persistence.VehicleListingDetails
import com.example.carfaxdemo.remote.VehicleListingModelMapper
import com.example.carfaxdemo.remote.VehicleListingService
import com.example.carfaxdemo.remote.remote_models.Response
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.SerialDisposable
import javax.inject.Inject

class Repository
    @Inject constructor (
    private val vehicleListingService: VehicleListingService,
    private val bgScheduler: Scheduler,
    private val uiScheduler: Scheduler,
    private val vehicleListingModelMapper: VehicleListingModelMapper,
    private val vehicleListingDao: VehicleListingDao
) {
    private val tag = Repository::class.java.simpleName
    private val disposable = SerialDisposable()

    init {
        syncVehicleListings()
    }

    private fun syncVehicleListings() {
        disposable.set(
            vehicleListingService.getVehicleListingList()
                .subscribeOn(bgScheduler)
                .observeOn(uiScheduler)
                .subscribe(this::onSyncSuccess, this::onSyncError)
        )
    }

    private fun onSyncSuccess(response: Response) {
        vehicleListingDao.insertAllVehicleListings(vehicleListingModelMapper.mapToLocalModel(response))
            .subscribeOn(bgScheduler)
            .observeOn(uiScheduler)
            .subscribe(
                { Log.d(tag, "Insert Success") },
                { Log.d(tag, "Insert Error") }
            )
    }

    private fun onSyncError(e: Throwable) {
        e.message?.let {
            Log.e(tag, it)
        }
    }

    fun getVehicleListings(): LiveData<List<VehicleListingDetails>> {
        return LiveDataReactiveStreams.fromPublisher(vehicleListingDao.getAllVehicleListings())
    }
}