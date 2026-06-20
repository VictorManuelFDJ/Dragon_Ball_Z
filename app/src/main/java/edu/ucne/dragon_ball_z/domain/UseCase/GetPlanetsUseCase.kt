package edu.ucne.dragon_ball_z.domain.UseCase

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val  repository: PlanetRepository
){
    suspend operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        isDestroyed: Boolean? = null
    ): Resource<List<PlanetDto>>{
        return repository.getPlanets(page,limit,name,isDestroyed)
    }
}