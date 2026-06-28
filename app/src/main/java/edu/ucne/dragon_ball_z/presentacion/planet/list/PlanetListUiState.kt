package edu.ucne.dragon_ball_z.presentacion.planet.list

import edu.ucne.dragon_ball_z.domain.model.planet.Planet

data class PlanetListUiState(
    val  isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val error: String? = null,
    val filterName: String = "",
    val filterIsDestroyed: Boolean? = null
)