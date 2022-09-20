package ucne.edu.prestamospersonalesap2s.UserInterface

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel

import edu.ucne.prestamospersonales.ui.ocupacionscreen.OcupacionViewModel


@Composable
fun RegistroOcupacionScreen(
    onNavigateBack: () -> Unit,
    viewModel: OcupacionViewModel = hiltViewModel()
) {
    var context = LocalContext.current

    fun validacionDeCampos() {

        if (viewModel.descripcion.isBlank()) {
            Toast.makeText(
                context,
                "Error, campo descripcion vacia, favor llenarlo",
                Toast.LENGTH_SHORT
            ).show()
        }
       else if (viewModel.salario.isBlank()) {
            Toast.makeText(
                context,
                "Error, campo salario vacio, favor llenarlo",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            viewModel.Guardar()
            Toast.makeText(
                context,
                "Ocupacion guardada con exito",
                Toast.LENGTH_SHORT
            ).show()
            onNavigateBack()
        }
    }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = { Text(text = "Registro de Ocupaciones") },
                modifier = Modifier.padding(0.dp),
                actions = {}
            )

            Spacer(modifier = Modifier.height(50.dp))


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion")},
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Salario")},
                value = viewModel.salario,
                onValueChange = {viewModel.salario = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
                   // viewModel.Validar()
                   validacionDeCampos()

                }) {
                Text(text = "Agregar Ocupacion")
            }

        }
    }

/*
@Composable
@Preview(showSystemUi = true)
fun Preview() {
    RegistroOcupacionesScreen( {  } )
}*/




