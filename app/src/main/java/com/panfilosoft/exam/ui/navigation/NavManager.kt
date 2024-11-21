package com.panfilosoft.exam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.panfilosoft.exam.ui.screens.AddScreen
import com.panfilosoft.exam.ui.screens.HomeScreen
import com.panfilosoft.exam.ui.screens.QuoteViewModel
import com.panfilosoft.exam.ui.screens.UpdateScreen

@Composable
fun NavManager(
    viewModel: QuoteViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            HomeScreen(viewModel, navController)
        }
        composable(Routes.Add.route) {
            AddScreen(viewModel, navController)
        }

        composable(
            Routes.Update.route + "/{id}/{name}/{phone}/{description}/{day}/{hour}",
            arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("name") { type = NavType.StringType },
                navArgument("phone") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("day") { type = NavType.StringType },
                navArgument("hour") { type = NavType.StringType }
            )
        ) {
            UpdateScreen(
                viewModel,
                navController,
                it.arguments?.getString("id")!!,
                it.arguments?.getString("name")!!,
                it.arguments?.getString("phone")!!,
                it.arguments?.getString("description")!!,
                it.arguments?.getString("day")!!,
                it.arguments?.getString("hour")!!,
            )
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Update : Routes("update")
    data object Add : Routes("add")
}
