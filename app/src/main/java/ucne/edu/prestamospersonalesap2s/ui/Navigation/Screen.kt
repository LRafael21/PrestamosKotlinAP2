package ucne.edu.prestamospersonalesap2s.ui.Navigation

sealed class Screen(val route: String){
    object ocupacionlistscreen: Screen("OcupacionListScreen")
    object registrocupacionscreen: Screen("RegistroOcupacionScreen")

    object personalistscreen: Screen("PersonaListScreen")
    object registropersonascreen: Screen("RegistroPersonaScreen")

    object prestamolistscreen: Screen("PrestamoListScreen")
    object registroprestamoscreen: Screen("RegistroPrestamoScreen")

    object home: Screen("HomeScreen")


}