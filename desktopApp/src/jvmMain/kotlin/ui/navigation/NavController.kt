package ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class NavController(
    private val startDestination: String
) {
    private val backStackScreens = mutableSetOf<String>()

    var currentScreen by mutableStateOf(startDestination)
        private set

    fun navigate(route: String, arguments: Map<String, String>? = null) {
        if (route != currentScreen && route != startDestination) {
            if (!arguments.isNullOrEmpty()) {
                NavArgumentController.putArguments(
                    NavArgument(
                        route = route,
                        arguments = arguments
                    )
                )
            }

            backStackScreens.add(currentScreen)
            currentScreen = route
        }
    }

    fun navigateBack() {
        if (backStackScreens.isNotEmpty()) {
            NavArgumentController.removeArguments(currentScreen)

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