package ucne.edu.prestamospersonalesap2s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ucne.edu.prestamospersonalesap2s.UserInterface.Home.HomeScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.Ocupaciones.List.OcupacionListScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroOcupacionScreen
import ucne.edu.prestamospersonalesap2s.ui.theme.PrestamosPersonalesAP2STheme
import ucne.edu.prestamospersonalesap2s.util.Screen
import androidx.compose.foundation.Image
import ucne.edu.prestamospersonalesap2s.UserInterface.Personas.List.PersonaListScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.Prestamos.List.PrestamoListScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.Prestamos.Screen.RegistroPrestamosScreen
import ucne.edu.prestamospersonalesap2s.UserInterface.RegistroPersonasScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   val prestamosDb = PrestamosDb.getInstance(this.applicationContext)

        setContent {
            PrestamosPersonalesAP2STheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.home.route
                    ) {
                        composable(Screen.home.route) {
                            HomeScreen(
                                OnClickOcupacion = { navController.navigate(Screen.ocupacionlistscreen.route) },
                                OnClickPersonas = {navController.navigate(Screen.personalistscreen.route)},
                                OnClickPrestamos = {navController.navigate(Screen.prestamolistscreen.route)}

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
            }


            /* @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PrestamosPersonalesAP2STheme {
            //     Screen(context = applicationContext)
        }*/
        }
    }
}