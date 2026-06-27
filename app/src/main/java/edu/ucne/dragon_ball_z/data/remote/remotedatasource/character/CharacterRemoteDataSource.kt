package edu.ucne.dragon_ball_z.data.remote.remotedatasource.character

import coil3.network.HttpException
import edu.ucne.dragon_ball_z.data.dto.character.CharacterDto
import edu.ucne.dragon_ball_z.data.dto.character.CharacterResponseDto
import edu.ucne.dragon_ball_z.data.remote.DragonBallApi
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val api: DragonBallApi
){
    suspend fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
        race: String?
    ): Result<CharacterResponseDto>{
        return try {
            val response = api.getCharacters(page, limit, name, gender, race)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red: ${response.code()}"))
            }
            Result.success(response.body()!!)
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun getCharacterDetail(id: Int): Result<CharacterDto> {
        return try {
            val response = api.getCharacterDetail(id)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red: ${response.code()}"))
            }
            Result.success(response.body()!!)
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }
}