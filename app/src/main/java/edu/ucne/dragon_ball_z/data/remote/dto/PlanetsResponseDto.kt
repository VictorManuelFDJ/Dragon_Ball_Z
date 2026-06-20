package edu.ucne.dragon_ball_z.data.remote.dto

import com.squareup.moshi.JsonClass
import edu.ucne.dragon_ball_z.domain.model.Planet


@JsonClass(generateAdapter = true)
data class PlanetsResponseDto(
    val items: List<PlanetDto>
)

@JsonClass(generateAdapter = true)
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