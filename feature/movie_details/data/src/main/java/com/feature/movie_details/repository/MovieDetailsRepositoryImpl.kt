package com.feature.movie_details.repository

import com.core.network.dataproviders.MovieDataSource
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repository.MovieDetailsRepository
import com.feature.movie_details.mapper.toDomain
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource
): MovieDetailsRepository {

    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails {
        return movieDataSource.getMovieDetails(id, apiKey).toDomain()
    }
}