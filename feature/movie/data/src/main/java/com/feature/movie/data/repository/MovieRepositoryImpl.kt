package com.feature.movie.data.repository

import com.core.network.dataproviders.MovieDataSource
import com.feature.movie.data.mapper.toDomainMovieList
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDataSource: MovieDataSource) :
    MovieRepository {

    override suspend fun getMovieList(apiKey: String, query: String): List<Movie> {
        return movieDataSource.getMovieList(apiKey, query).toDomainMovieList()
    }
}