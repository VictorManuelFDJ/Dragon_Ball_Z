package edu.ucne.dragon_ball_z.presentacion.charecter.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import edu.ucne.dragon_ball_z.domain.model.character.Character

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel = hiltViewModel(),
    onCharacterClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Personajes") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            ElevatedCard(modifier = Modifier.padding(16.dp)) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = state.filterName,
                        onValueChange = { viewModel.onEvent(CharacterListEvent.OnNameChanged(it)) },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = state.filterGender,
                            onValueChange = { viewModel.onEvent(CharacterListEvent.OnGenderChanged(it)) },
                            label = { Text("Género") },
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = state.filterRace,
                            onValueChange = { viewModel.onEvent(CharacterListEvent.OnRaceChanged(it)) },
                            label = { Text("Raza") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Button(
                        onClick = { viewModel.onEvent(CharacterListEvent.OnSearch) },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Buscar")
                    }
                }
            }


            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            if (state.error.isNotBlank()) {
                Text(text = state.error, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))
            }


            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(state.characters) { character ->
                    CharacterItem(character = character, onClick = { onCharacterClick(character.id) })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = character.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "Raza: ${character.race}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Ki: ${character.ki}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}