package com.abvanpelt.restaurantsnearme.di

import com.abvanpelt.restaurantsnearme.repository.LocationRepository
import com.abvanpelt.restaurantsnearme.repository.LocationRepositoryImpl
import com.abvanpelt.restaurantsnearme.repository.PlacesRepository
import com.abvanpelt.restaurantsnearme.repository.PlacesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository

    @Singleton
    @Binds
    abstract fun bindPlacesRepository(
        placesRepositoryImpl: PlacesRepositoryImpl
    ): PlacesRepository
}