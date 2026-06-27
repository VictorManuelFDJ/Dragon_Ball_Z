package edu.ucne.dragon_ball_z.presentacion.charecter.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.dragon_ball_z.data.remote.Resource
import edu.ucne.dragon_ball_z.domain.UseCase.characters.GetCharactersUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListUiState())
    val state = _state.asStateFlow()

    init {
        loadCharacters()
    }

    fun onEvent(event: CharacterListEvent) {
        when (event) {
            is CharacterListEvent.OnNameChanged -> _state.update { it.copy(filterName = event.name) }
            is CharacterListEvent.OnGenderChanged -> _state.update { it.copy(filterGender = event.gender) }
            is CharacterListEvent.OnRaceChanged -> _state.update { it.copy(filterRace = event.race) }
            CharacterListEvent.OnSearch -> loadCharacters()
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            val current = _state.value

            val nameFilter = current.filterName.takeIf { it.isNotBlank() }
            val genderFilter = current.filterGender.takeIf { it.isNotBlank() }
            val raceFilter = current.filterRace.takeIf { it.isNotBlank() }

            getCharactersUseCase(
                name = nameFilter,
                gender = genderFilter,
                race = raceFilter
            ).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update {
                        it.copy(isLoading = true
                            , error = ""
                        )

                    }
                    is Resource.Success -> _state.update {
                        it.copy(
                            isLoading = false,
                            characters = result.data ?: emptyList()
                        )
                    }
                    is Resource.Error -> _state.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "Error desconocido",
                            characters = emptyList()
                        )
                    }
                }
            }
        }
    }
}