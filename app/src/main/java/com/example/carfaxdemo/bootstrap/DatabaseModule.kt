package com.example.carfaxdemo.bootstrap

import android.content.Context
import androidx.room.Room
import com.example.carfaxdemo.persistence.AppDatabase
import com.example.carfaxdemo.persistence.VehicleListingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun getVehicleListingDao(appDatabase: AppDatabase): VehicleListingDao {
        return appDatabase.vehicleListingDao()
    }

    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "AppDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }
}