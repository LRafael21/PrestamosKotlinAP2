package ucne.edu.prestamospersonalesap2s.util

sealed class Screen(val route: String){
    object ocupacionlistscreen: Screen("OcupacionListScreen")
    object registrocupacionscreen: Screen("RegistroOcupacionScreen")

    object personalistscreen: Screen("PersonaListScreen")
    object registropersonascreen: Screen("RegistroPersonaScreen")

    object home: Screen("HomeScreen")


}