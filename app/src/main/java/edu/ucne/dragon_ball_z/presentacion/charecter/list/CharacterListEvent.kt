package edu.ucne.dragon_ball_z.presentacion.charecter.list


sealed interface CharacterListEvent {
    data class OnNameChanged(val name: String) : CharacterListEvent
    data class OnGenderChanged(val gender: String) : CharacterListEvent
    data class OnRaceChanged(val race: String) : CharacterListEvent
    data object OnSearch : CharacterListEvent
}