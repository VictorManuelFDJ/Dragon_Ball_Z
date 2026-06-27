package edu.ucne.dragon_ball_z.presentacion.planet.detail


import edu.ucne.dragon_ball_z.domain.model.planet.Planet

data class DetailPlanetUiState (
    val isLoading: Boolean = false,
    val planet: Planet? = null,
    val error: String? = null
)