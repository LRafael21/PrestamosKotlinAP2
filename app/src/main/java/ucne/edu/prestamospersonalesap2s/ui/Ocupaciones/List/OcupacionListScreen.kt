package ucne.edu.prestamospersonalesap2s.ui.Ocupaciones.List

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ucne.edu.prestamospersonalesap2s.data.entity.Ocupacion


@Composable
fun OcupacionListScreen(
    OnClickOcupacion: () -> Unit,
    viewModel: OcupacionListViewModel = hiltViewModel()
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = OnClickOcupacion) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Ocupacion")
            }

        },

        ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            OcupacionList(
                ocupacion = uiState.ocupaciones,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )

        }
    }


}


@Composable
fun OcupacionList(
    ocupacion: List<Ocupacion>,
    viewModel: OcupacionListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "Lista de Ocupaciones") },
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
        items(ocupacion) { ocupacion ->
            OcupacionRow(ocupacion, viewModel)
        }
    }

}

@Composable
fun OcupacionRow(ocupacion: Ocupacion, viewModel: OcupacionListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Row() {
            Text(
                text = "Descripción: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${ocupacion.descripcion} "
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            Text(
                text = "Salario: ",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = " ${ocupacion.salario} "
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {


            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = { viewModel.DeleteOcupacion(ocupacion) }) {
                Icon(
                    imageVector = Icons.Outlined.Clear, contentDescription = "delete",
                    tint = Color.Red,

                    )
            }

            IconButton(
                onClick = { viewModel.DeleteOcupacion(ocupacion) }) {
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