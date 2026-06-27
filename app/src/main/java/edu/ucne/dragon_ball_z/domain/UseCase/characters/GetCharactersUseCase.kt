package edu.ucne.dragon_ball_z.domain.UseCase.characters

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.character.Character
import edu.ucne.dragon_ball_z.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        gender: String? = null,
        race: String? = null
    ): Flow<Resource<List<Character>>>{
        return repository.getCharacters(page,limit,name,gender,race)
    }
}