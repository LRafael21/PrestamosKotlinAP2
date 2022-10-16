package edu.ucne.prestamospersonales.ui.ocupacionscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.data.entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.repository.OcupacionRepository
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val repository: OcupacionRepository
) : ViewModel() {
    var descripcion by mutableStateOf("")
    var salario by mutableStateOf("")



    fun Guardar() {
        viewModelScope.launch {
            repository.insertOcupacion(
                Ocupacion(
                    descripcion = descripcion,
                    salario = salario.toDouble()
                )

            )
        }

    }
}