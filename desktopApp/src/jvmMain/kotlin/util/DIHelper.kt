package util

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.viewmodel.HomeViewModel
import ui.viewmodel.VolumeDetailViewModel
import ui.viewmodel.VolumeListViewModel

class DIHelper : KoinComponent {
    val homeViewModel by inject<HomeViewModel>()
    val volumeListViewModel by inject<VolumeListViewModel>()
    val volumeDetailViewModel by inject<VolumeDetailViewModel>()
}