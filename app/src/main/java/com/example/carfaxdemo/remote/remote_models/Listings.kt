package com.example.carfaxdemo.remote.remote_models

import com.google.gson.annotations.SerializedName

data class Listings(
    val dealer: Dealer?,
    val vin: String,
    val mileage: Int?,
    val currentPrice: Double?,
    val exteriorColor: String?,
    val interiorColor: String?,
    val engine: String?,
    @SerializedName("drivetype")
    val driveType: String?,
    val transmission: String?,
    @SerializedName("bodytype")
    val bodyType: String?,
    val images: Image?,
    val year: Int?,
    val make: String?,
    val model: String?,
    val trim: String?,
    val fuel: String?
)
