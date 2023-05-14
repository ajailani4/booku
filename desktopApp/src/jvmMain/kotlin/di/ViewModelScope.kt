package di

import com.ajailani.booku.util.Constants
import org.koin.core.qualifier.named
import org.koin.dsl.module
import viewmodel.HomeViewModel

val viewModelModule = module {
    single {
        HomeViewModel(
            get(),
            get(named(Constants.CoroutineDispatcher.DEFAULT_DISPATCHER))
        )
    }
}