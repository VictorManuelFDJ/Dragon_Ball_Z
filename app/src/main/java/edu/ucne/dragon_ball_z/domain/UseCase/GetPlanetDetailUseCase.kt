package edu.ucne.dragon_ball_z.domain.UseCase

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.Planet
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlanetDetailUseCase @Inject constructor(
    private val repository: PlanetRepository
){
    operator fun invoke(id: Int): Flow<Resource<Planet>>{
        return repository.getPlanetDetail(id)
    }
}
