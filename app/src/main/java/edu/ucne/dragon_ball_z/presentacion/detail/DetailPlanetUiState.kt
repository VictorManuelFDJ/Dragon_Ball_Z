package edu.ucne.dragon_ball_z.presentacion.detail


import edu.ucne.dragon_ball_z.domain.model.Planet

data class DetailPlanetUiState (
    val isLoading: Boolean = false,
    val planet: Planet? = null,
    val error: String? = null
)