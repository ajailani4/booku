package ui.navigation

object NavArgumentController {
    private val navArguments = mutableListOf<NavArgument>()

    fun putArguments(navArgument: NavArgument) {
        navArguments.add(navArgument)
    }

    fun getArguments(route: String) =
        navArguments.find { it.route == route }?.arguments

    fun removeArguments(route: String) {
        navArguments.remove(navArguments.find { it.route == route })
    }
}