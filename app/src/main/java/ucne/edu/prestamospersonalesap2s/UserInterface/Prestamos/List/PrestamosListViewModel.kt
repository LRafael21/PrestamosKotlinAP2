package ucne.edu.prestamospersonalesap2s.UserInterface.Prestamos.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.Entity.Prestamo
import ucne.edu.prestamospersonalesap2s.data.PersonasRepository
import ucne.edu.prestamospersonalesap2s.data.PrestamosRepository
import javax.inject.Inject

data class PrestamoListUIState(
    val prestamos: List<Prestamo> = emptyList(),

    )

@HiltViewModel
class PrestamosListViewModel @Inject constructor(
    val repository: PrestamosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PrestamoListUIState())
    val uiState: StateFlow<PrestamoListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect { list ->
                _uiState.update {
                    it.copy(prestamos = list)
                }
            }
        }
    }

    fun DeletePrestamo(prestamo: Prestamo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePrestamo(prestamo)
        }
    }

    fun UpdatePrestamo(prestamo: Prestamo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePrestamo(prestamo)
        }
    }
}