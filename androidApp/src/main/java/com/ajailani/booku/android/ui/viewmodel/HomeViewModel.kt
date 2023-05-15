package com.ajailani.booku.android.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import com.ajailani.booku.ui.screen.home.HomeUiState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getVolumesUseCase: GetVolumesUseCase
) : ViewModel() {
    var homeUiState by mutableStateOf(HomeUiState())
        private set

    init {
        getVolumesByCategory()
    }

    private fun getVolumesByCategory() {
        homeUiState = homeUiState.copy(loading = true)

        viewModelScope.launch {
            getFictionVolumes()
            getScienceVolumes()
            getTechnologyVolumes()
            getSocialVolumes()
            getBusinessVolumes()

            homeUiState = homeUiState.copy(loading = false)
        }
    }

    private suspend fun getFictionVolumes() {
        getVolumesUseCase(
            query = "subject:fiction",
            maxResults = 15
        ).catch {
            homeUiState = homeUiState.copy(errorMessage = it.message)
        }.collect {
            homeUiState = when (it) {
                is Resource.Success -> homeUiState.copy(fictionVolumes = it.data)

                is Resource.Error -> homeUiState.copy(errorMessage = it.message)
            }
        }
    }

    private suspend fun getScienceVolumes() {
        getVolumesUseCase(
            query = "subject:science",
            maxResults = 15
        ).catch {
            homeUiState = homeUiState.copy(errorMessage = it.message)
        }.collect {
            homeUiState = when (it) {
                is Resource.Success -> homeUiState.copy(scienceVolumes = it.data)

                is Resource.Error -> homeUiState.copy(errorMessage = it.message)
            }
        }
    }

    private suspend fun getTechnologyVolumes() {
        getVolumesUseCase(
            query = "subject:technology",
            maxResults = 15
        ).catch {
            homeUiState = homeUiState.copy(errorMessage = it.message)
        }.collect {
            homeUiState = when (it) {
                is Resource.Success -> homeUiState.copy(technologyVolumes = it.data)

                is Resource.Error -> homeUiState.copy(errorMessage = it.message)
            }
        }
    }

    private suspend fun getSocialVolumes() {
        getVolumesUseCase(
            query = "subject:social",
            maxResults = 15
        ).catch {
            homeUiState = homeUiState.copy(errorMessage = it.message)
        }.collect {
            homeUiState = when (it) {
                is Resource.Success -> homeUiState.copy(socialVolumes = it.data)

                is Resource.Error -> homeUiState.copy(errorMessage = it.message)
            }
        }
    }

    private suspend fun getBusinessVolumes() {
        getVolumesUseCase(
            query = "subject:business",
            maxResults = 15
        ).catch {
            homeUiState = homeUiState.copy(errorMessage = it.message)
        }.collect {
            homeUiState = when (it) {
                is Resource.Success -> homeUiState.copy(businessVolumes = it.data)

                is Resource.Error -> homeUiState.copy(errorMessage = it.message)
            }
        }
    }
}