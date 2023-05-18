package di

import com.ajailani.booku.util.Constants
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ui.viewmodel.HomeViewModel
import ui.viewmodel.VolumeDetailViewModel
import ui.viewmodel.VolumeListViewModel

val viewModelModule = module {
    single {
        HomeViewModel(
            get(),
            get(named(Constants.CoroutineDispatcher.DEFAULT_DISPATCHER))
        )
    }

    single {
        VolumeListViewModel(
            get(),
            get(named(Constants.CoroutineDispatcher.DEFAULT_DISPATCHER))
        )
    }

    single {
        VolumeDetailViewModel(
            get(),
            get(named(Constants.CoroutineDispatcher.DEFAULT_DISPATCHER))
        )
    }
}