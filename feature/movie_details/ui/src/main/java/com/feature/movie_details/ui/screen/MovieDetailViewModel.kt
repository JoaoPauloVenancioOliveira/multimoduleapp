package com.feature.movie_details.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvents
import com.feature.movie_details.domain.use_cases.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailStateHolder())
    val movieDetails: State<MovieDetailStateHolder> get() = _movieDetails

    private val key = "b0603b9326ab7ea7720dbd352a1717d0"

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(it, key)
            }
        }
    }

    private fun getMovieDetails(id: String, apiKey: String) {
        getMovieDetailsUseCase(id, apiKey).onEach {
            when (it) {
                is UiEvents.Loading -> {
                    _movieDetails.value = MovieDetailStateHolder(isLoading = true)
                }

                is UiEvents.Error -> {
                    _movieDetails.value = MovieDetailStateHolder(error = it.message.toString())
                }

                is UiEvents.Success -> {
                    _movieDetails.value = MovieDetailStateHolder(data = it.data)

                }
            }
        }.launchIn(viewModelScope)
    }

}