package ucne.edu.prestamospersonalesap2s.UserInterface.Personas.Screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.data.PersonasRepository
import javax.inject.Inject

@HiltViewModel
class PersonasViewModel @Inject constructor(
    val repository: PersonasRepository
) : ViewModel() {
    var nombres by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("")


    fun Guardar() {
        viewModelScope.launch {
            repository.insertPersona(
                Persona(
                    nombres = nombres,
                    telefono = telefono,
                    celular = celular,
                    email = email,
                    direccion = direccion,
                    fechaNacimiento = fechaNacimiento
                )

            )
        }

    }
}