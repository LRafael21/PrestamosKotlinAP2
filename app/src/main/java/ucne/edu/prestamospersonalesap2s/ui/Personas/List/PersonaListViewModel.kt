package ucne.edu.prestamospersonalesap2s.ui.Personas.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.data.entity.Persona
import ucne.edu.prestamospersonalesap2s.repository.PersonasRepository
import javax.inject.Inject

data class PersonaListUIState(
    val personas: List<Persona> = emptyList(),

    )

@HiltViewModel
class PersonaListViewModel @Inject constructor(
    val repository: PersonasRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonaListUIState())
    val uiState: StateFlow<PersonaListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy(personas = list)
                }
            }
        }
    }

    fun DeletePersona(persona: Persona) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePersona(persona)
        }
    }

}