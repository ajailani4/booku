package ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import com.ajailani.booku.ui.screen.volume_list.VolumeListUiState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class VolumeListViewModel(
    private val getVolumesUseCase: GetVolumesUseCase,
    private val defaultDispatcher: CoroutineDispatcher
) {
    var volumeListUiState by mutableStateOf(VolumeListUiState())
        private set

    fun getVolumes(query: String) {
        volumeListUiState = volumeListUiState.copy(loading = true)

        CoroutineScope(defaultDispatcher).launch {
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