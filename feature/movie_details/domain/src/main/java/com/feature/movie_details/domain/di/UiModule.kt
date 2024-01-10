package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repository.MovieDetailsRepository
import com.feature.movie_details.domain.use_cases.GetMovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideGetMovieDetailUseCase(movieDetailsRepository: MovieDetailsRepository): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(movieDetailsRepository)
    }
}