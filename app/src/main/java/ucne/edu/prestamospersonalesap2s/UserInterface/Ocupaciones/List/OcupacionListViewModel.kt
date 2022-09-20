package ucne.edu.prestamospersonalesap2s.UserInterface.Ocupaciones.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.data.OcupacionRepository
import javax.inject.Inject

data class OcupacionListUIState(
    val ocupaciones: List<Ocupacion> = emptyList(),

    )

@HiltViewModel
class OcupacionListViewModel @Inject constructor(
    val repository: OcupacionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OcupacionListUIState())
    val uiState: StateFlow<OcupacionListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy(ocupaciones = list)
                }
            }
        }
    }

    fun DeleteOcupacion(ocupacion: Ocupacion) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteOcupacion(ocupacion)
        }
    }

        fun UpdateOcupacion(ocupacion: Ocupacion) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateOcupacion(ocupacion)
            }
        }
}