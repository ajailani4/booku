package ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ajailani.booku.domain.use_case.GetVolumeDetailUseCase
import com.ajailani.booku.ui.screen.volume_detail.VolumeDetailUiState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class VolumeDetailViewModel(
    private val getVolumeDetailUseCase: GetVolumeDetailUseCase,
    private val defaultDispatcher: CoroutineDispatcher
) {
    var volumeDetailUiState by mutableStateOf(VolumeDetailUiState())
        private set

    fun getVolumeDetail(id: String) {
        volumeDetailUiState = volumeDetailUiState.copy(loading = true)

        CoroutineScope(defaultDispatcher).launch {
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