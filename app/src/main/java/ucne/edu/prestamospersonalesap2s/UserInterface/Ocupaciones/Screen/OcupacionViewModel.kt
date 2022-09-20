package edu.ucne.prestamospersonales.ui.ocupacionscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.data.OcupacionRepository
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