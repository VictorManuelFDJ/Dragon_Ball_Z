package edu.ucne.dragon_ball_z.domain.UseCase.planet

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.planet.Planet
import edu.ucne.dragon_ball_z.domain.repository.planet.PlanetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val repository: PlanetRepository
){
    operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        isDestroyed: Boolean? = null
    ): Flow<Resource<List<Planet>>> {
        return repository.getPlanets(page, limit, name, isDestroyed)
    }
}