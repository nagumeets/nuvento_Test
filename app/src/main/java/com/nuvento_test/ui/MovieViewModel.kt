package com.nuvento_test.ui

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuvento_test.repository.*
import com.google.gson.Gson
import com.nuvento_test.data.model.MovieFeedResponse
import com.nuvento_test.data.model.Response
import com.nuvento_test.data.model.Search
import com.nuvento_test.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow<ViewState<List<Search>>>(ViewState.loading())

    // UI collect from this stateFlow to get the state updates
    val uiState: StateFlow<ViewState<List<Search>>> = _uiState

    fun getMovieList() {
        viewModelScope.launch {
            coroutineScope {
                movieRepository.getMovieFeed()
                    .distinctUntilChanged()
                    .collect { result ->
                        when (result) {
                            is Response.Success -> _uiState.value =
                                ViewState.Success(result.data)!!
                            is Response.Error -> _uiState.value = ViewState.Failed(result.message)
                        }
                    }
            }
        }
    }
}