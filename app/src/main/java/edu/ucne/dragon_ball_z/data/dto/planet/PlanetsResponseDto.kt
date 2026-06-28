package edu.ucne.dragon_ball_z.data.dto.planet

import edu.ucne.dragon_ball_z.domain.model.planet.Planet

data class PlanetsResponseDto(
    val items: List<PlanetDto>
)

data class PlanetDto(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
){
    fun toDomain() = Planet(
        id,
        name,
        isDestroyed,
        description,
        image
    )
}