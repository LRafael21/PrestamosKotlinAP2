package ucne.edu.prestamospersonalesap2s.UserInterface.Prestamos.List

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
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.Entity.Prestamo
import ucne.edu.prestamospersonalesap2s.UserInterface.Personas.List.PersonaListViewModel

@Composable
fun PrestamoListScreen(
    onClickPrestamos: () -> Unit,
    viewModel: PrestamosListViewModel = hiltViewModel()
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onClickPrestamos) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Prestamo")
            }

        },

        ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            PrestamoList(
                prestamo = uiState.prestamos,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )

        }
    }


}


@Composable
fun PrestamoList(
    prestamo: List<Prestamo>,
    viewModel: PrestamosListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "Lista de Prestamos") },
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
        items(prestamo) { prestamo ->
            PrestamoRow(prestamo, viewModel)
        }
    }

}

@Composable
fun PrestamoRow(
    prestamo: Prestamo,
    viewModel: PrestamosListViewModel
) {
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row() {
            Text(
                text = "Fecha: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${prestamo.fecha} "
            )
        }

        Row() {
            Text(
                text = "Vence: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${prestamo.vence} "
            )
        }
        Row() {
            Text(
                text = "Concepto: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${prestamo.concepto} "
            )
        }
        Row() {
            Text(
                text = "Monto: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${prestamo.monto} "
            )
        }
        Row() {
            Text(
                text = "Balance: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${prestamo.balance} "
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = { viewModel.DeletePrestamo(prestamo)   }) {

                Icon(
                    imageVector = Icons.Outlined.Clear, contentDescription = "delete",
                    tint = Color.Red,
                )
            }

            IconButton(
                onClick = { viewModel.DeletePrestamo(prestamo) }) {
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
