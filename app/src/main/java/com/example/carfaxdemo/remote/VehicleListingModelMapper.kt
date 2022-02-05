package com.example.carfaxdemo.remote

import com.example.carfaxdemo.persistence.VehicleListingDetails
import com.example.carfaxdemo.remote.remote_models.Response

class VehicleListingModelMapper {
    fun mapToLocalModel(model: Response): List<VehicleListingDetails> {
        val localModelList: MutableList<VehicleListingDetails> = mutableListOf()
        for (listingItem in model.listings!!) {
            localModelList.add(
                VehicleListingDetails(
                    listingItem.vin,
                    listingItem.year,
                    listingItem.mileage,
                    listingItem.dealer?.phone,
                    listingItem.currentPrice,
                    listingItem.exteriorColor,
                    listingItem.interiorColor,
                    listingItem.engine,
                    listingItem.driveType,
                    listingItem.transmission,
                    listingItem.bodyType,
                    listingItem.images?.firstPhoto?.large,
                    listingItem.make,
                    listingItem.model,
                    listingItem.trim,
                    listingItem.dealer?.city,
                    listingItem.dealer?.state
                )
            )
        }
        return localModelList
    }
}