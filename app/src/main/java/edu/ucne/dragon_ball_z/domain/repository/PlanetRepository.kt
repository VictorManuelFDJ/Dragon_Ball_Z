package edu.ucne.dragon_ball_z.domain.repository

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto
import edu.ucne.dragon_ball_z.domain.model.Planet

interface PlanetRepository {
    suspend fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
        isDestroyed: Boolean?
    ): Resource<List<PlanetDto>>

    suspend fun getPlanetDetail(id: Int): Resource<PlanetDto>
}