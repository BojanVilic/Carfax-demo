package com.example.carfaxdemo.core

import com.example.carfaxdemo.Constants.Companion.IO_SCHEDULER
import com.example.carfaxdemo.Constants.Companion.UI_SCHEDULER
import com.example.carfaxdemo.ui.details.DetailsViewModel
import com.example.carfaxdemo.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun getHomeViewModel(
        @Named(IO_SCHEDULER) bgScheduler: Scheduler,
        @Named(UI_SCHEDULER) uiScheduler: Scheduler
    ): HomeViewModel {
        return HomeViewModel(bgScheduler, uiScheduler)
    }

    @Provides
    fun getDetailsViewModel(
        @Named(IO_SCHEDULER) bgScheduler: Scheduler,
        @Named(UI_SCHEDULER) uiScheduler: Scheduler
    ): DetailsViewModel {
        return DetailsViewModel(bgScheduler, uiScheduler)
    }
}