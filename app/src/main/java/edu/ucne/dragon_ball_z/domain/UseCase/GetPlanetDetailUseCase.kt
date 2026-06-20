package edu.ucne.dragon_ball_z.domain.UseCase

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.dto.PlanetDto
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetDetailUseCase @Inject constructor(
    private val repository: PlanetRepository
){
    suspend  operator fun invoke(id: Int): Resource<PlanetDto>{
        return repository.getPlanetDetail(id)
    }
}