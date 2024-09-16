package kr.lul.template.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kr.lul.template.ui.atom.TemplateTheme
import kr.lul.template.ui.page.FirstPage
import kr.lul.template.ui.page.SecondPage
import kr.lul.template.ui.page.SplashPage

@Composable
fun Root() {
    TemplateTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splash") {
            composable("splash") {
                SplashPage(navController)
            }
            composable("first") {
                FirstPage(navController)
            }
            composable(
                route = "second/{id}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.IntType
                    }
                )
            ) {
                SecondPage(navController)
            }
        }
    }
}