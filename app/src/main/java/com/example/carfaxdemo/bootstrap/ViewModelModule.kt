package com.example.carfaxdemo.bootstrap

import com.example.carfaxdemo.repository.Repository
import com.example.carfaxdemo.ui.details.DetailsViewModel
import com.example.carfaxdemo.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun getHomeViewModel(
        repository: Repository
    ): HomeViewModel {
        return HomeViewModel(repository)
    }

    @Provides
    fun getDetailsViewModel(): DetailsViewModel {
        return DetailsViewModel()
    }
}