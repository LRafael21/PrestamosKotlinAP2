package ucne.edu.prestamospersonalesap2s.UserInterface

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ucne.edu.prestamospersonalesap2s.ui.Personas.Screen.PersonasViewModel

@Composable
fun RegistroPersonasScreen(
    onNavigateBack: () -> Unit,
    viewModel: PersonasViewModel = hiltViewModel()
) {

    var context = LocalContext.current

    /*fun validacionDeCampos() {

        if (viewModel.nombres.isBlank()) {
            Toast.makeText(
                context,
                "Error, campo descripcion vacia, favor llenarlo",
                Toast.LENGTH_SHORT
            ).show()
        } else if (viewModel.fechaNacimeinto.isBlank()) {
            Toast.makeText(
                context,
                "Error, campo salario vacio, favor llenarlo",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            viewModel.Guardar()
            Toast.makeText(
                context,
                "Ocupacion guardada con exito",
                Toast.LENGTH_SHORT
            ).show()
            onNavigateBack()
        }
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            title = { Text(text = "Registro de Personas") },
            modifier = Modifier.padding(0.dp),
            actions = {}
        )
        val scope = rememberCoroutineScope()
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nombres") },
            value = viewModel.nombres,
            onValueChange = { viewModel.nombres = it }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Telefono") },
            value = viewModel.telefono,
            onValueChange = { viewModel.telefono = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Celular") },
            value = viewModel.celular,
            onValueChange = { viewModel.celular = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            value = viewModel.email,
            onValueChange = { viewModel.email = it },

            )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Direccion") },
            value = viewModel.direccion,
            onValueChange = { viewModel.direccion = it },

            )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Fecha de Nacimiento") },
            value = viewModel.fechaNacimiento,
            onValueChange = { viewModel.fechaNacimiento = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        var Expanded by remember { mutableStateOf(false) }

        val Ocupaciones = listOf("Doctor", "Ingeniero", "Abogado", "Profesor")

        var SelectedText by remember { mutableStateOf("") }

        val icon = if (Expanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        Column(Modifier.padding(0.dp)) {

            OutlinedTextField(
                value = SelectedText,
                onValueChange = { SelectedText = it },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                label = { Text("Ocupaciones") },
                trailingIcon = {
                    Icon(icon, "DropDownMenu de ocupaciones",
                        Modifier.clickable { Expanded = !Expanded })
                }
            )

            DropdownMenu(
                expanded = Expanded,
                onDismissRequest = { Expanded = false },
                modifier = Modifier
            ) {
                Ocupaciones.forEach { Ocupacion ->
                    DropdownMenuItem(onClick = {
                        SelectedText = Ocupacion
                        Expanded = false
                    }) {
                        Text(text = Ocupacion)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),

            onClick = {
                viewModel.Guardar()
                onNavigateBack()
            }

        ) {

            Text(text = "Agregar Persona")

        }


    }
}
