package edu.ucne.dragon_ball_z.domain.repository

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.Planet
import kotlinx.coroutines.flow.Flow

interface PlanetRepository {
    fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
        isDestroyed: Boolean?
    ): Flow<Resource<List<Planet>>>

    fun getPlanetDetail(id: Int): Flow<Resource<Planet>>
}