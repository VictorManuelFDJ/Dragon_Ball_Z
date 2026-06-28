package edu.ucne.dragon_ball_z.data.remote


import edu.ucne.dragon_ball_z.data.dto.character.CharacterDto
import edu.ucne.dragon_ball_z.data.dto.character.CharacterResponseDto
import edu.ucne.dragon_ball_z.data.dto.planet.PlanetDto
import edu.ucne.dragon_ball_z.data.dto.planet.PlanetsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonBallApi {
    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String?,
        @Query("isDestroyed") isDestroyed: Boolean?
    ): Response<PlanetsResponseDto>

    @GET("planets/{id}")
    suspend fun getPlanetDetail(
        @Path("id") id: Int
    ): Response<PlanetDto>

    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("name") name: String? = null,
        @Query("gender") gender: String? = null,
        @Query("race") race: String? = null
    ): Response<CharacterResponseDto>

    @GET("characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): Response<CharacterDto>
}