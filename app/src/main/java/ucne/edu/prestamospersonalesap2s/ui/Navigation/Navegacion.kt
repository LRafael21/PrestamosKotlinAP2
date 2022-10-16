package ucne.edu.prestamospersonalesap2s.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroOcupacionScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroPersonasScreen
import ucne.edu.prestamospersonalesap2s.ui.Home.HomeScreen
import ucne.edu.prestamospersonalesap2s.ui.Ocupaciones.List.OcupacionListScreen
import ucne.edu.prestamospersonalesap2s.ui.Personas.List.PersonaListScreen
import ucne.edu.prestamospersonalesap2s.ui.Prestamos.List.PrestamoListScreen
import ucne.edu.prestamospersonalesap2s.ui.Prestamos.Screen.RegistroPrestamosScreen

@Composable
fun Navegacion() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.home.route
    ) {
        composable(Screen.home.route) {
            HomeScreen(
                OnClickOcupacion = { navController.navigate(Screen.ocupacionlistscreen.route) },
                OnClickPersonas = { navController.navigate(Screen.personalistscreen.route) },
                OnClickPrestamos = { navController.navigate(Screen.prestamolistscreen.route) }

            )
        }
        composable(Screen.ocupacionlistscreen.route) {
            OcupacionListScreen({ navController.navigateUp() })
        }
        composable(Screen.ocupacionlistscreen.route) {
            OcupacionListScreen(
                OnClickOcupacion = { navController.navigate(Screen.registrocupacionscreen.route) }
            )
        }
        composable(Screen.registrocupacionscreen.route) {
            RegistroOcupacionScreen({ navController.navigateUp() })
        }


        composable(Screen.personalistscreen.route) {
            PersonaListScreen({ navController.navigateUp() })
        }
        composable(Screen.personalistscreen.route) {
            PersonaListScreen(
                onClickPersonas = { navController.navigate(Screen.registropersonascreen.route) }
            )
        }

        composable(Screen.registropersonascreen.route) {
            RegistroPersonasScreen({ navController.navigateUp() })
        }

        //Prestamos
        composable(Screen.registroprestamoscreen.route) {
            RegistroPrestamosScreen({ navController.navigateUp() })
        }

        composable(Screen.prestamolistscreen.route) {
            PrestamoListScreen({ navController.navigateUp() })
        }
        composable(Screen.prestamolistscreen.route) {
            PrestamoListScreen(
                onClickPrestamos = { navController.navigate(Screen.registroprestamoscreen.route) }
            )
        }
        composable(Screen.registroprestamoscreen.route) {
            RegistroPrestamosScreen({ navController.navigateUp() })
        }


    }


}