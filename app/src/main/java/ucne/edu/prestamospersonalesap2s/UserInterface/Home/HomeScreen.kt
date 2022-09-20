package ucne.edu.prestamospersonalesap2s.UserInterface.Home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onClick: () -> Unit,
    OnClickPersonas: () -> Unit
) {
    val painter = painterResource(id = ucne.edu.prestamospersonalesap2s.R.drawable.money_27)
    val descripcion = "Prestamos Personales"
    val title = "Prestamos Personales"


    var expanded by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = { Text(text = "Prestamos Personales") },
            navigationIcon = {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)

            },
            actions = {

                IconButton(onClick = onClick) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Agregar Una Ocupacion/Lista de Ocupaciones"
                    )

                }

                IconButton(onClick = OnClickPersonas) {
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "Agregar Una Persona/Lista de Personas"
                    )

                }
            }
        )

        Box(modifier = Modifier.fillMaxWidth())
        {
            ImageCard(
                painter = painter,
                contentDescripcion = descripcion,
                title = title
            )
            //Botones para los diferentes registros
           /* Row() {
                Button(onClick = { /*TODO*/ }) {

                }
            }*/

        }

    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescripcion: String,
    title: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.height(200.dp))
        {
            Image(
                painter = painter,
                contentDescription = contentDescripcion,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black,
                            ),
                            startY = 200f
                        )
                    )
            )
            {}
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    title, style = TextStyle(
                        color = Color.Red,
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Cursive
                    )
                )

            }
        }
    }

}


