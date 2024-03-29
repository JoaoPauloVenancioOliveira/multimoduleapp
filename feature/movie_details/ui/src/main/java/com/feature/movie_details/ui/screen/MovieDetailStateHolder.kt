package com.feature.movie_details.ui.screen

import com.feature.movie_details.domain.model.MovieDetails

data class MovieDetailStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null,
    )
