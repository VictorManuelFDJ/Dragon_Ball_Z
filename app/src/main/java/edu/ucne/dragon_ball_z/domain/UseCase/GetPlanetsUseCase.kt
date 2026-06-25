package edu.ucne.dragon_ball_z.domain.UseCase

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.Planet
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
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
