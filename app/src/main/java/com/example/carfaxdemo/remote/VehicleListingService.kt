package com.example.carfaxdemo.remote

import com.example.carfaxdemo.Constants.NetworkCalls.VEHICLE_LISTINGS_LIST
import com.example.carfaxdemo.remote.remote_models.Response
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface VehicleListingService {
    @GET(VEHICLE_LISTINGS_LIST)
    fun getVehicleListingList(): Observable<Response>
}