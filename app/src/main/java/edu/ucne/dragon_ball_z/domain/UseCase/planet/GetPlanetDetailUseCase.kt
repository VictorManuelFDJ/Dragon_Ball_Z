package edu.ucne.dragon_ball_z.domain.UseCase.planet

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.planet.Planet
import edu.ucne.dragon_ball_z.domain.repository.planet.PlanetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlanetDetailUseCase @Inject constructor(
    private val repository: PlanetRepository
){
    operator fun invoke(id: Int): Flow<Resource<Planet>> {
        return repository.getPlanetDetail(id)
    }
}