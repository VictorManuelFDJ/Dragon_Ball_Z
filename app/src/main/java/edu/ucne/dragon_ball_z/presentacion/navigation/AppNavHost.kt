package edu.ucne.dragon_ball_z.presentacion.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.dragon_ball_z.presentacion.detail.PlanetDetailScreen
import edu.ucne.dragon_ball_z.presentacion.list.PlanetListScreen



@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PlanetList,

        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it / 3 },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it / 3 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        composable<Screen.PlanetList> {
            PlanetListScreen(
                onPlanetClick = { planetId ->
                    navHostController.navigate(Screen.PlanetDetail(id = planetId))
                }
            )
        }

        composable<Screen.PlanetDetail> {
            PlanetDetailScreen(
                onBack = {
                    navHostController.navigateUp()
                }
            )
        }
    }
}