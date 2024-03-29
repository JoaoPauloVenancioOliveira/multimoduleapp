package com.feature.movie.data.di

import com.core.network.dataproviders.MovieDataSource
import com.feature.movie.data.repository.MovieRepositoryImpl
import com.feature.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepo(movieDataSource: MovieDataSource): MovieRepository {
        return MovieRepositoryImpl(movieDataSource)
    }
}