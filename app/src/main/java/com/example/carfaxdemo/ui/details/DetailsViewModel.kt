package com.example.carfaxdemo.ui.details

import androidx.lifecycle.ViewModel
import com.example.carfaxdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject constructor(
    repository: Repository
) : ViewModel() {
    // TODO: Implement the ViewModel
}