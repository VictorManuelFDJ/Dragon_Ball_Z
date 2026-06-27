package edu.ucne.dragon_ball_z.domain.repository.character

import edu.ucne.dragon_ball_z.domain.model.character.Character
import edu.ucne.dragon_ball_z.data.remote.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
         race: String?
    ): Flow<Resource<List<Character>>>

    fun getCharacterDetail(id: Int): Flow<Resource<Character>>
}
