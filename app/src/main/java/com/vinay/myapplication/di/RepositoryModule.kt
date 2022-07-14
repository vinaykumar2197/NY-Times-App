package com.vinay.myapplication.di

import com.vinay.myapplication.data.repository.AppRepositoryImpl
import com.vinay.myapplication.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: AppRepositoryImpl
    ): AppRepository
}