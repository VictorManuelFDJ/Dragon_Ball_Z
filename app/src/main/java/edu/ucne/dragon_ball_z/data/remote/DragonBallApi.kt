package edu.ucne.dragon_ball_z.data.remote

import androidx.room.Query
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetsResponseDto
import okhttp3.Response

interface DragonBallApi {
    @Get("planets")
    suspend fun getPlanets(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String?,
        @Query("isDestroyed") isDestroyed: Boolean?
    ): Response<PlanetsResponseDto>

    @Get("planets/{id}")
    suspend fun getPlanetDetail(
        @path("id") id: Int
    ): Response<PlanetDto>
}