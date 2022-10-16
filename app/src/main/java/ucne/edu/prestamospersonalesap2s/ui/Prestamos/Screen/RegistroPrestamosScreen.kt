package ucne.edu.prestamospersonalesap2s.ui.Prestamos.Screen

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
fun RegistroPrestamosScreen(
    onNavigateBack: () -> Unit,
    viewModel: PrestamosViewModel = hiltViewModel()
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
            title = { Text(text = "Registro de Prestamos") },
            modifier = Modifier.padding(0.dp),
            actions = {}
        )
        val scope = rememberCoroutineScope()
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Fecha") },
            value = viewModel.fecha,
            onValueChange = { viewModel.fecha = it }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Vence") },
            value = viewModel.vence,
            onValueChange = { viewModel.vence = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        var Expanded by remember { mutableStateOf(false) }

        val Personas = listOf("Rafael", "Nicole", "Maria", "Jeison","Samuel","SaiSai")

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
                label = { Text("Persona") },
                trailingIcon = {
                    Icon(icon, "DropDownMenu de personas",
                        Modifier.clickable { Expanded = !Expanded })
                }
            )

            DropdownMenu(
                expanded = Expanded,
                onDismissRequest = { Expanded = false },
                modifier = Modifier
            ) {
                Personas.forEach { Persona ->
                    DropdownMenuItem(onClick = {
                        SelectedText = Persona
                        Expanded = false
                    }) {
                        Text(text = Persona)
                    }
                }
            }
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Concepto") },
            value = viewModel.concepto,
            onValueChange = { viewModel.concepto = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Monto") },
            value = viewModel.monto,
            onValueChange = { viewModel.monto = it },

            )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Balance") },
            value = viewModel.balance,
            onValueChange = { viewModel.balance = it },

            )


        Spacer(modifier = Modifier.height(5.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),

            onClick = {
                viewModel.Guardar()
            }

        ) {

            Text(text = "Agregar Prestamo")

        }


    }
}
