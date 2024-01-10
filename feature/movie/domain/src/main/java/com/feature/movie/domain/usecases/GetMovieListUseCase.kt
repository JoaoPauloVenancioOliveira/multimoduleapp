package com.feature.movie.domain.usecases

import com.core.common.UiEvents
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke(apiKey: String, query: String) = flow {
        emit(UiEvents.Loading())
        emit(UiEvents.Success(movieRepository.getMovieList(apiKey, query)))

    }.catch {
        emit(UiEvents.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}