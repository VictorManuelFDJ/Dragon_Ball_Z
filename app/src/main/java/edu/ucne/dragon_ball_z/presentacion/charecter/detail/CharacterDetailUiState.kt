package edu.ucne.dragon_ball_z.presentacion.charecter.detail

import edu.ucne.dragon_ball_z.domain.model.character.Character

data class CharacterDetailUiState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String = ""
)