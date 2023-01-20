package com.abvanpelt.restaurantsnearme.di

import com.abvanpelt.restaurantsnearme.repository.PermissionsRepository
import com.abvanpelt.restaurantsnearme.repository.PermissionsRepositoryImpl
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
    abstract fun bindPermissionsRepository(
        permissionsRepositoryImpl: PermissionsRepositoryImpl
    ): PermissionsRepository
}