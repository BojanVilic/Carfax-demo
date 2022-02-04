package com.example.carfaxdemo.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    bgScheduler: Scheduler,
    uiScheduler: Scheduler
) : ViewModel() {
    // TODO: Implement the ViewModel
}