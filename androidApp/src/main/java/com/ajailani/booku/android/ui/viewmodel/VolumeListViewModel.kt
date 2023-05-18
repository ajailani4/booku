package com.ajailani.booku.android.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import com.ajailani.booku.ui.screen.volume_list.VolumeListUiState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class VolumeListViewModel(
    savedStateHandle: SavedStateHandle,
    private val getVolumesUseCase: GetVolumesUseCase
) : ViewModel() {
    val query = savedStateHandle.get<String>("query")

    var volumeListUiState by mutableStateOf(VolumeListUiState())
        private set

    init {
        getVolumes()
    }

    private fun getVolumes() {
        volumeListUiState = volumeListUiState.copy(loading = true)

        viewModelScope.launch {
            if (query != null) {
                getVolumesUseCase(
                    query = query,
                    maxResults = 40
                ).catch {
                    volumeListUiState = volumeListUiState.copy(
                        loading = false,
                        errorMessage = it.message
                    )
                }.collect {
                    volumeListUiState = when (it) {
                        is Resource.Success -> volumeListUiState.copy(
                            loading = false,
                            volumes = it.data ?: emptyList()
                        )

                        is Resource.Error -> volumeListUiState.copy(
                            loading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }
}