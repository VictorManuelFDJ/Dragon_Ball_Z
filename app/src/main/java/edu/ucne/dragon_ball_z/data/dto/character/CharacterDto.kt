package edu.ucne.dragon_ball_z.data.dto.character

import edu.ucne.dragon_ball_z.domain.model.character.Character


data class CharacterResponseDto(
val items: List<CharacterDto>
)

data class CharacterDto(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String
){
    fun toDomain() = Character(
        id = id,
        name = name,
        ki = ki,
        maxKi = maxKi,
        race = race,
        gender = gender,
        description = description,
        image = image
    )
}