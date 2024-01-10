package com.feature.movie.ui.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvents
import com.feature.movie.domain.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchStateHolder())
    val movieList: State<MovieSearchStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    private val key = "b0603b9326ab7ea7720dbd352a1717d0"

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(key, it)
            }
        }
    }

    fun setQuery(s: String) {
        _query.value = s
    }


    private fun getMovieList(apiKey: String, query: String) = viewModelScope.launch {

        getMovieListUseCase.invoke(apiKey, query).onEach {
            when (it) {
                is UiEvents.Loading -> {
                    _movieList.value = MovieSearchStateHolder(isLoading = true)
                }
                is UiEvents.Error -> {
                    _movieList.value = MovieSearchStateHolder(error = it.message.toString())
                }
                is UiEvents.Success -> {
                    _movieList.value = MovieSearchStateHolder(data = it.data)

                }
            }

        }.launchIn(viewModelScope)
    }
}