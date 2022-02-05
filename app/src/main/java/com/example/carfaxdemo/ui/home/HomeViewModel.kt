package com.example.carfaxdemo.ui.home

import androidx.lifecycle.ViewModel
import com.example.carfaxdemo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    repository: Repository
) : ViewModel() {

}