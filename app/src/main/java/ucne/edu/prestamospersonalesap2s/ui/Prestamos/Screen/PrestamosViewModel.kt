package ucne.edu.prestamospersonalesap2s.ui.Prestamos.Screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.data.entity.Prestamo
import ucne.edu.prestamospersonalesap2s.repository.PrestamosRepository
import javax.inject.Inject

@HiltViewModel
class PrestamosViewModel @Inject constructor(
    val repository: PrestamosRepository
) : ViewModel() {
    var fecha by mutableStateOf("")
    var vence by mutableStateOf("")
    var concepto by mutableStateOf("")
    var monto by mutableStateOf("")
    var balance by mutableStateOf("")


    fun Guardar() {
        viewModelScope.launch {
            repository.insertPrestamo(
                Prestamo(
                    fecha = fecha,
                    vence = vence,
                    concepto = concepto,
                    monto = monto.toDouble(),
                    balance = balance.toDouble()
                )

            )
        }

    }
}