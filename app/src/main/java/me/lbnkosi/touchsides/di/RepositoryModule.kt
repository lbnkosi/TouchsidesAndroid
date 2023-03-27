package me.lbnkosi.touchsides.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.lbnkosi.touchsides.data.repository.TouchsidesRepository
import me.lbnkosi.touchsides.data.service.TouchsidesApiService
import me.lbnkosi.touchsides.data.source.remote.TouchsidesDataSource
import me.lbnkosi.touchsides.domain.usecase.TouchsideApiUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesTouchsidesApiUseCase(touchsidesRepository: TouchsidesRepository): TouchsideApiUseCase = TouchsideApiUseCase(touchsidesRepository)

    @Provides
    fun providesTouchsidesRemoteDataSource(touchsidesApiService: TouchsidesApiService): TouchsidesDataSource = TouchsidesDataSource(touchsidesApiService)

}