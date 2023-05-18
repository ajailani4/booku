package ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import com.ajailani.booku.ui.screen.volume_list.VolumeListUiState
import com.ajailani.booku.util.Resource
import com.ajailani.booku.util.Screen
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import ui.navigation.NavArgument

class VolumeListViewModel(
    private val getVolumesUseCase: GetVolumesUseCase,
    private val defaultDispatcher: CoroutineDispatcher
) {
    //val query = NavArgument.getArguments(Screen.VolumeList.route)?.get("query")

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
                        volumes = it.data
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