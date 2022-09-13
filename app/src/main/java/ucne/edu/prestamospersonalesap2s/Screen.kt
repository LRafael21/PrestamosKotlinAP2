package ucne.edu.prestamospersonalesap2s

sealed class Screen(val route: String){
    object RegistroScreenKT: Screen("RScreen")
    object ScreenPrueba: Screen("PScreen")

}