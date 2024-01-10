package com.feature.movie_details.di

import com.core.network.dataproviders.MovieDataSource
import com.feature.movie_details.domain.repository.MovieDetailsRepository
import com.feature.movie_details.repository.MovieDetailsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideMovieDetailRepo(movieDataSource: MovieDataSource): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(movieDataSource)
    }
}