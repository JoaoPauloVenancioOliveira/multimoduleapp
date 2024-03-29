package com.example.movieappyoutube.di

import com.example.movieappyoutube.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailsApi: MovieDetailApi
    ): NavigationProvider {
        return NavigationProvider(
            movieApi,
            movieDetailsApi
        )
    }

}