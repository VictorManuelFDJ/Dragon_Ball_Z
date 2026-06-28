package edu.ucne.dragon_ball_z.domain.UseCase.characters

import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.model.character.Character
import edu.ucne.dragon_ball_z.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(id: Int): Flow<Resource<Character>>{
        return repository.getCharacterDetail(id)
    }
}