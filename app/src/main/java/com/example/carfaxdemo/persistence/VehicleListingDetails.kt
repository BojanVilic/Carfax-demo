package com.example.carfaxdemo.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "vehicle_listings")
data class VehicleListingDetails (
    @PrimaryKey
    val vin: String,
    val year: Int?,
    val mileage: Int?,
    val phone: Long?,
    val currentPrice: Double?,
    val exteriorColor: String?,
    val interiorColor: String?,
    val engine: String?,
    val driveType: String?,
    val transmission: String?,
    val bodyType: String?,
    val photo: String?,
    val make: String?,
    val model: String?,
    val trim: String?,
    val city: String?,
    val state: String?,
    val fuel: String?
): Serializable