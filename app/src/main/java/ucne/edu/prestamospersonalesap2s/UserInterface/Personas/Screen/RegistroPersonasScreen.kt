package ucne.edu.prestamospersonalesap2s.UserInterface

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.ui.ocupacionscreen.OcupacionViewModel
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.UserInterface.Personas.Screen.PersonasViewModel
import ucne.edu.prestamospersonalesap2s.data.PrestamosDb

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
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        val scope = rememberCoroutineScope()

        Text(
            text = "Registro de Personas",
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(25.dp))

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
            value = viewModel.fechaNacimeinto,
            onValueChange = { viewModel.fechaNacimeinto = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            //TextField Salario
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Ocupacion") },
            value = "ocupacionId",
            onValueChange = { },
        )
        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Ocupaciones")
        }

        Button(
            modifier = Modifier.fillMaxWidth(),

            onClick = { viewModel.Guardar()
            }

        ) {

            Text(text = "Agregar Persona")

        }


    }
}