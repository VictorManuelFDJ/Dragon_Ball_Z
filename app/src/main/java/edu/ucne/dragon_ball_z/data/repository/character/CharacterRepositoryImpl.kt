package edu.ucne.dragon_ball_z.data.repository.character

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.data.remote.remotedatasource.character.CharacterRemoteDataSource
import edu.ucne.dragon_ball_z.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import edu.ucne.dragon_ball_z.domain.model.character.Character


class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
        race: String?
    ): Flow<Resource<List<Character>>> = flow {

        emit(Resource.Loading())

        val response = remoteDataSource.getCharacters(page, limit, name, gender, race)

        response.onSuccess { dto ->

            emit(Resource.Success(dto.items.map { it.toDomain() }))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }

    override fun getCharacterDetail(id: Int): Flow<Resource<Character>> = flow {
        emit(Resource.Loading())

        val response = remoteDataSource.getCharacterDetail(id)

        response.onSuccess { characterDto ->
            emit(Resource.Success(characterDto.toDomain()))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }
}