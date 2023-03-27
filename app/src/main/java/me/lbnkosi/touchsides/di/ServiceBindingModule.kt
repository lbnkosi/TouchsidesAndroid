package me.lbnkosi.touchsides.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.lbnkosi.touchsides.domain.repository.ITouchsidesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceBindingModule {

    @Singleton
    @Binds
    abstract fun bindTouchsidesRepository(touchsidesRepository: ITouchsidesRepository): ITouchsidesRepository

}