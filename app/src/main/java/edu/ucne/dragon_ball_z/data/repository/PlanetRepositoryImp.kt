package edu.ucne.dragon_ball_z.data.repository

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.remotedatasource.PlanetRemoteDataSource
import edu.ucne.dragon_ball_z.domain.model.Planet
import edu.ucne.dragon_ball_z.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlanetRepositoryImp @Inject constructor(
    private val remoteDataSource: PlanetRemoteDataSource
) : PlanetRepository {

    override fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
        isDestroyed: Boolean?
    ): Flow<Resource<List<Planet>>> = flow {

        emit(Resource.Loading())

        val response = remoteDataSource.getPlanets(page, limit, name, isDestroyed)

        response.onSuccess { planetsResponse ->

            val planetasDominio = planetsResponse.items.map { it.toDomain() }
            emit(Resource.Success(planetasDominio))
        }.onFailure { exception ->
            emit(Resource.Error(exception.message ?: "Error desconocido al obtener planetas"))
        }
    }

    override fun getPlanetDetail(id: Int): Flow<Resource<Planet>> = flow {

        emit(Resource.Loading())

        val response = remoteDataSource.getPlanetDetail(id)

        response.onSuccess { planetDto ->

            emit(Resource.Success(planetDto.toDomain()))
        }.onFailure { exception ->
            emit(Resource.Error(exception.message ?: "Error desconocido al obtener el detalle"))
        }
    }
}