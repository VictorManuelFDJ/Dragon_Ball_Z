package edu.ucne.dragon_ball_z.domain.model.planet

data class Planet(
    val  id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String
)