package ucne.edu.prestamospersonalesap2s.UserInterface.Personas.List

import android.app.Person
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.UserInterface.Ocupaciones.List.OcupacionListViewModel
import ucne.edu.prestamospersonalesap2s.UserInterface.Ocupaciones.List.OcupacionRow
import ucne.edu.prestamospersonalesap2s.UserInterface.Personas.Screen.PersonasViewModel

@Composable
fun PersonaListScreen(
    onClickPersonas: () -> Unit,
    viewModel: PersonaListViewModel = hiltViewModel()
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onClickPersonas) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Persona")
            }

        },

        ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            PersonaList(
                persona = uiState.personas,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )

        }
    }


}


@Composable
fun PersonaList(
    persona: List<Persona>,
    viewModel: PersonaListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "Lista de Personas") },
        modifier = Modifier.padding(0.dp),
        actions = {}
    )

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        color = Color.Red
    )

    Spacer(modifier = Modifier.height(15.dp))

    LazyColumn(
        modifier = modifier,
    ) {
        items(persona) { persona ->
            PersonaRow(persona, viewModel)
        }
    }

}

@Composable
fun PersonaRow(
    persona: Persona,
    viewModel: PersonaListViewModel
) {
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row() {
            Text(
                text = "Nombres: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.nombres} "
            )
        }

        Row() {
            Text(
                text = "Telefono: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.telefono} "
            )
        }
        Row() {
            Text(
                text = "Celular: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.celular} "
            )
        }
        Row() {
            Text(
                text = "Email: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.email} "
            )
        }
        Row() {
            Text(
                text = "Direccion: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.direccion} "
            )
        }
        Row() {
            Text(
                text = "Fecha de Nacimiento: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${persona.fechaNacimiento} "
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

                IconButton(
                    modifier = Modifier.padding(0.dp),
                    onClick = { viewModel.DeletePersona(persona)   }) {

                    Icon(
                        imageVector = Icons.Outlined.Clear, contentDescription = "delete",
                        tint = Color.Red,
                        )
                }

                IconButton(
                    onClick = { viewModel.DeletePersona(persona) }) {
                    Icon(
                        imageVector = Icons.Outlined.Add, contentDescription = "add",
                        tint = Color.Blue,

                        )
                }


        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            color = Color.Red
        )
    }
}
