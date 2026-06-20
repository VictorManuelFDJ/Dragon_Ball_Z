package edu.ucne.dragon_ball_z.presentacion.list

import edu.ucne.dragon_ball_z.domain.model.Planet

data class PlanetListUiState(
    val  isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val error: String? = null,
    val filterName: String = "",
    val filterIsDestroyed: Boolean? = null
)