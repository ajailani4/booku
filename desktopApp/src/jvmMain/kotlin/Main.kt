import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ajailani.booku.di.appModule
import com.ajailani.booku.ui.screen.home.HomeScreen
import com.ajailani.booku.ui.theme.BookuTheme
import di.viewModelModule
import org.koin.core.context.startKoin
import util.DIHelper

fun main() = application {
    initKoin()

    Window(onCloseRequest = ::exitApplication) {
        BookuTheme {
            val homeViewModel = DIHelper().homeViewModel
            val homeUiState = homeViewModel.homeUiState

            HomeScreen(
                homeUiState = homeUiState,
                onNavigateToVolumeList = {}
            )
        }
    }
}

private fun initKoin() {
    startKoin {
        modules(appModule, viewModelModule)
    }
}