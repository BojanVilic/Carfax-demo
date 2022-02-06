package com.example.carfaxdemo.ui.details

import androidx.lifecycle.ViewModel
import com.example.carfaxdemo.persistence.VehicleListingDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject constructor() : ViewModel() {
    var vehicleListingDetails: VehicleListingDetails? = null
}