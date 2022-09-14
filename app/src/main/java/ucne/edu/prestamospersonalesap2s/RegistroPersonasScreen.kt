package ucne.edu.prestamospersonalesap2s

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.data.PrestamosDb

@Composable
fun RegistroPersonasScreen(context: Context) {

    val prestamosDb = PrestamosDb.getInstance(context)

    var nombres by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var ocupacionId by remember { mutableStateOf("") }
    // A surface container using the 'background' color from the theme
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        val scope = rememberCoroutineScope()

        Text(
            //Text Label
            text = "Registro de Personas",
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(25.dp)) //Spacer between Text and Descripción

        OutlinedTextField(                  //TextField Descripción
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nombres") },
            value = nombres,
            onValueChange = { nombres = it }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Telefono") },
            value = telefono,
            onValueChange = { telefono = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Celular") },
            value = celular,
            onValueChange = { celular = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Email") },
            value = email,
            onValueChange = { email = it },

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Direccion") },
            value = direccion,
            onValueChange = { direccion = it },

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(), //TextField Salario
            label = { Text(text = "Fecha de Nacimiento") },
            value = fechaNacimiento,
            onValueChange = { fechaNacimiento = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

            OutlinedTextField( //TextField Salario
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ocupacion") },
                value = ocupacionId,
                onValueChange = { ocupacionId = it },
            )
        Spacer(modifier = Modifier.height(5.dp)) //Spacer between Text and Descripción

            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Ocupaciones")

            }


        Spacer(modifier = Modifier.height(150.dp)) //Spacer between Text and Descripción

        Button(
            modifier = Modifier.fillMaxWidth(),

            onClick = {
                if (nombres.isNullOrEmpty()) {

                   println("Vacio")
                }
                else {

                    scope.launch {
                        prestamosDb.DaoPersonas.insert(
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

        ) {

            Text(text = "Agregar Persona")

        }


    }
}