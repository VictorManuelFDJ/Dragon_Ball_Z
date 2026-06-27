package edu.ucne.dragon_ball_z.domain.model.character

data class Character (
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String
)