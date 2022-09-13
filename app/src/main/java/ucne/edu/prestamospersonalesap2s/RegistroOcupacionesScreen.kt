package ucne.edu.prestamospersonalesap2s

import android.content.Context
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
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.data.PrestamosDb



    @Composable
    fun RegistroScreenKT(context: Context) {

        val prestamosDb = PrestamosDb.getInstance(context)

        var descripcion by remember { mutableStateOf("") }
        var salario by remember { mutableStateOf("") }
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
                text = "Registro de Ocupaciones",
                fontSize = 25.sp,
            )
            Spacer(modifier = Modifier.height(25.dp)) //Spacer between Text and Descripción

            OutlinedTextField(                  //TextField Descripción
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripción") },
                value = descripcion,
                onValueChange = { descripcion = it }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), //TextField Salario
                label = { Text(text = "Salario") },
                value = salario,
                onValueChange = { salario = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            Spacer(modifier = Modifier.height(25.dp)) //Spacer between Text and Descripción

            Button(
                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    scope.launch {
                        prestamosDb.DaoOcupaciones.insert(
                            Ocupacion(
                                descripcion = descripcion,
                                salario = salario.toDouble()
                            )
                            //Validar que solo se pogan double

                        )
                    }

                }

            ) {

                Text(text = "Agregar Ocupacion")

            }


        }
    }


