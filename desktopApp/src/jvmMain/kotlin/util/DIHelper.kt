package util

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.viewmodel.HomeViewModel

class DIHelper : KoinComponent {
    val homeViewModel by inject<HomeViewModel>()
}