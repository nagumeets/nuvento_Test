package com.nuvento_test.di

import com.nuvento_test.repository.MovieRepository
import com.nuvento_test.repository.impl.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun providesMovieFeedRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
