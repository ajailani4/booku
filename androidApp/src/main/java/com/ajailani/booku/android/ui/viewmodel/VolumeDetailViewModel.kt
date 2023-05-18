package com.ajailani.booku.android.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajailani.booku.domain.use_case.GetVolumeDetailUseCase
import com.ajailani.booku.ui.screen.volume_detail.VolumeDetailUiState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VolumeDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val getVolumeDetailUseCase: GetVolumeDetailUseCase
) : ViewModel() {
    private val id = savedStateHandle.get<String>("id")

    var volumeDetailUiState by mutableStateOf(VolumeDetailUiState())
        private set

    init {
        getVolumeDetail()
    }

    private fun getVolumeDetail() {
        volumeDetailUiState = volumeDetailUiState.copy(loading = true)

        viewModelScope.launch {
            if (id != null) {
                getVolumeDetailUseCase(id).catch {
                    volumeDetailUiState = volumeDetailUiState.copy(
                        loading = false,
                        errorMessage = it.message
                    )
                }.collect {
                    volumeDetailUiState = when (it) {
                        is Resource.Success -> volumeDetailUiState.copy(
                            loading = false,
                            volumeInfo = it.data
                        )

                        is Resource.Error -> volumeDetailUiState.copy(
                            loading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }
}