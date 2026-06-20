package edu.ucne.dragon_ball_z.presentacion.detail

import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto

data class DetailPlanetUiState (
    val isLoading: Boolean = false,
    val planet: PlanetDto? = null,
    val error: String? = null
)