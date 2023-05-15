import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ajailani.booku.di.appModule
import com.ajailani.booku.ui.theme.BookuTheme
import com.ajailani.booku.util.Screen
import di.viewModelModule
import org.koin.core.context.startKoin
import ui.navigation.NavHost
import ui.navigation.rememberNavController

fun main() = application {
    initKoin()

    Window(onCloseRequest = ::exitApplication) {
        BookuTheme {
            val navController = rememberNavController(startDestination = Screen.Home.route)

            NavHost(navController)
        }
    }
}

private fun initKoin() {
    startKoin {
        modules(appModule, viewModelModule)
    }
}