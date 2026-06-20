package edu.ucne.dragon_ball_z.presentacion.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object PlanetList : Screen()

    @Serializable
    data class PlanetDetail(val id: Int) : Screen()
}