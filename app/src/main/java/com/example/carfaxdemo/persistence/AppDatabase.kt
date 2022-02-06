package com.example.carfaxdemo.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [VehicleListingDetails::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleListingDao(): VehicleListingDao
}