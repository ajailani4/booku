package viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.use_case.GetVolumesUseCase
import com.ajailani.booku.ui.common.UIState
import com.ajailani.booku.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getVolumesUseCase: GetVolumesUseCase,
    private val defaultDispatcher: CoroutineDispatcher
) {
    var fictionVolumesState by mutableStateOf<UIState<List<Volume>>>(UIState.Idle)
        private set

    var scienceVolumesState by mutableStateOf<UIState<List<Volume>>>(UIState.Idle)
        private set

    var technologyVolumesState by mutableStateOf<UIState<List<Volume>>>(UIState.Idle)
        private set

    var socialVolumesState by mutableStateOf<UIState<List<Volume>>>(UIState.Idle)
        private set

    var businessVolumesState by mutableStateOf<UIState<List<Volume>>>(UIState.Idle)
        private set

    init {
        getFictionVolumes()
        getScienceVolumes()
        getTechnologyVolumes()
        getSocialVolumes()
        getBusinessVolumes()
    }

    private fun getFictionVolumes() {
        fictionVolumesState = UIState.Loading

        CoroutineScope(defaultDispatcher).launch {
            getVolumesUseCase(
                query = "subject:fiction",
                maxResults = 15
            ).catch {
                fictionVolumesState = UIState.Error(it.message)
            }.collect {
                fictionVolumesState = when (it) {
                    is Resource.Success -> UIState.Success(it.data)

                    is Resource.Error -> UIState.Error(it.message)
                }
            }
        }
    }

    private fun getScienceVolumes() {
        scienceVolumesState = UIState.Loading

        CoroutineScope(defaultDispatcher).launch {
            getVolumesUseCase(
                query = "subject:science",
                maxResults = 15
            ).catch {
                scienceVolumesState = UIState.Error(it.message)
            }.collect {
                scienceVolumesState = when (it) {
                    is Resource.Success -> UIState.Success(it.data)

                    is Resource.Error -> UIState.Error(it.message)
                }
            }
        }
    }

    private fun getTechnologyVolumes() {
        technologyVolumesState = UIState.Loading

        CoroutineScope(defaultDispatcher).launch {
            getVolumesUseCase(
                query = "subject:technology",
                maxResults = 15
            ).catch {
                technologyVolumesState = UIState.Error(it.message)
            }.collect {
                technologyVolumesState = when (it) {
                    is Resource.Success -> UIState.Success(it.data)

                    is Resource.Error -> UIState.Error(it.message)
                }
            }
        }
    }

    private fun getSocialVolumes() {
        socialVolumesState = UIState.Loading

        CoroutineScope(defaultDispatcher).launch {
            getVolumesUseCase(
                query = "subject:social",
                maxResults = 15
            ).catch {
                socialVolumesState = UIState.Error(it.message)
            }.collect {
                socialVolumesState = when (it) {
                    is Resource.Success -> UIState.Success(it.data)

                    is Resource.Error -> UIState.Error(it.message)
                }
            }
        }
    }

    private fun getBusinessVolumes() {
        businessVolumesState = UIState.Loading

        CoroutineScope(defaultDispatcher).launch {
            getVolumesUseCase(
                query = "subject:business",
                maxResults = 15
            ).catch {
                businessVolumesState = UIState.Error(it.message)
            }.collect {
                businessVolumesState = when (it) {
                    is Resource.Success -> UIState.Success(it.data)

                    is Resource.Error -> UIState.Error(it.message)
                }
            }
        }
    }
}