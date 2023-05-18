package ui.navigation

object NavArgument {
    // The first element in Pair is a screen route. The second is arguments
    private val navArguments = mutableSetOf<Pair<String, Map<String, String>>>()

    fun putArguments(
        route: String,
        arguments: Map<String, String>
    ) {
        navArguments.add(Pair(route, arguments))
    }

    fun getArguments(route: String) =
        navArguments.find { it.first == route }?.second

    fun removeArguments(route: String) =
        navArguments.remove(navArguments.find { it.first == route })
}