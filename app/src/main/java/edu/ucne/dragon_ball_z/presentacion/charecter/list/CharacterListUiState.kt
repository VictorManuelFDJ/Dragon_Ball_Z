package edu.ucne.dragon_ball_z.presentacion.charecter.list
import edu.ucne.dragon_ball_z.domain.model.character.Character

data class CharacterListUiState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = "",
    val filterName: String = "",
    val filterGender: String = "",
    val filterRace: String = ""
)