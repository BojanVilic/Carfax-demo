package com.example.carfaxdemo.ui.models

import java.io.Serializable

data class VehicleListingDetails (
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
    val vin: String?
): Serializable