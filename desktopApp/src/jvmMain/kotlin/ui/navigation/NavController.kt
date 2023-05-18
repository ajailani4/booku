package ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.ajailani.booku.util.Screen

class NavController(
    private val startDestination: String
) {
    private val backStackScreens = mutableSetOf<String>()

    var currentScreen by mutableStateOf(startDestination)
        private set

    fun navigate(route: String, arguments: Map<String, String>? = null) {
        if (route != currentScreen && route != startDestination) {
            if (!arguments.isNullOrEmpty()) {
                NavArgument.putArguments(
                    route = route,
                    arguments = arguments
                )
            }

            backStackScreens.add(currentScreen)
            currentScreen = route
        }
    }

    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            NavArgument.removeArguments(currentScreen)

            backStackScreens.last().let {
                currentScreen = it
                backStackScreens.remove(it)
            }
        }
    }
}

@Composable
fun rememberNavController(startDestination: String) = rememberSaveable {
    NavController(startDestination)
}