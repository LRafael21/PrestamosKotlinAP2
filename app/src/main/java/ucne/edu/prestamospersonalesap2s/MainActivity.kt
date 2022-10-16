package ucne.edu.prestamospersonalesap2s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ucne.edu.prestamospersonalesap2s.ui.Home.HomeScreen
import ucne.edu.prestamospersonalesap2s.ui.Ocupaciones.List.OcupacionListScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroOcupacionScreen
import ucne.edu.prestamospersonalesap2s.ui.theme.PrestamosPersonalesAP2STheme
import ucne.edu.prestamospersonalesap2s.ui.Navigation.Screen
import ucne.edu.prestamospersonalesap2s.ui.Personas.List.PersonaListScreen
import ucne.edu.prestamospersonalesap2s.ui.Prestamos.List.PrestamoListScreen
import ucne.edu.prestamospersonalesap2s.ui.Prestamos.Screen.RegistroPrestamosScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroPersonasScreen
import ucne.edu.prestamospersonalesap2s.ui.Navigation.Navegacion

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrestamosPersonalesAP2STheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navegacion()
                }
            }
        }
    }
}
