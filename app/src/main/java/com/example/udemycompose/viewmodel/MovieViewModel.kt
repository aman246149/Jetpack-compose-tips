package com.example.udemycompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.udemycompose.datasource.MovieApi
import com.example.udemycompose.model.MarsPhoto
import kotlinx.coroutines.launch

sealed interface MovieUiState {
    data class Success(val data: Any) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}

class MyMovieViewModel : ViewModel() {
    var moviewUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    init {
        getMoviesData()
    }

    fun getMoviesData() {
        viewModelScope.launch {
            try {
                val listResult = MovieApi.retrofitService.getMovies()
                moviewUiState = MovieUiState.Success(listResult)
            } catch (e: Exception) {
                println(e.message);
                moviewUiState = MovieUiState.Error
            }
        }

    }
}