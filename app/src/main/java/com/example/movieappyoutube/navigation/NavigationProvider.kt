package com.example.movieappyoutube.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_details.ui.navigation.MovieDetailApi

data class NavigationProvider (
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailApi
)