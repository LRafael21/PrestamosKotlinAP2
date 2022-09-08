package ucne.edu.prestamospersonalesap2s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.data.PrestamosDb
import ucne.edu.prestamospersonalesap2s.ui.theme.PrestamosPersonalesAP2STheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val prestamosDb = PrestamosDb.getInstance(this.applicationContext)
        setContent {
            PrestamosPersonalesAP2STheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scope = rememberCoroutineScope()
                    
                    Button(onClick = { 
                        scope.launch {
                            prestamosDb.DaoOcupaciones.insert(
                        Ocupacion(
                            descripcion = "Ingeniero",
                            salario = 10000.0
                        )
                    
                    )
                    } }) {
                        Text(text = "Agregar Ocupacion")
                        
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrestamosPersonalesAP2STheme {
        Greeting("Android")
    }
}