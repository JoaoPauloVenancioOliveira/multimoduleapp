package com.feature.movie_details.ui.di

import com.feature.movie_details.ui.navigation.MovieDetailApi
import com.feature.movie_details.ui.navigation.MovieDetailApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideMovieDetailApi(): MovieDetailApi {
        return MovieDetailApiImpl()
    }
}