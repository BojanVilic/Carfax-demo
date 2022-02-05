package com.example.carfaxdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.carfaxdemo.persistence.VehicleListingDetails
import com.example.carfaxdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun getVehicleListings(): LiveData<List<VehicleListingDetails>> {
        return repository.getVehicleListings()
    }
}