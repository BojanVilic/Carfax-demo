package com.example.carfaxdemo.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface VehicleListingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllVehicleListings(list: List<VehicleListingDetails>) : Completable

    @Query("SELECT * FROM vehicle_listings")
    fun getAllVehicleListings(): Flowable<List<VehicleListingDetails>>
}