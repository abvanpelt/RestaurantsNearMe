package com.abvanpelt.restaurantsnearme.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Singleton
    @Provides
    fun provideFusedLocationProviderClient(
        @ApplicationContext appContext: Context
    ): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(appContext)
    }
}