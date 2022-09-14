package ucne.edu.prestamospersonalesap2s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import ucne.edu.prestamospersonalesap2s.ui.theme.PrestamosPersonalesAP2STheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   val prestamosDb = PrestamosDb.getInstance(this.applicationContext)

        setContent {
            PrestamosPersonalesAP2STheme {
                //RegistroScreenKT(context = applicationContext)
                RegistroPersonasScreen(context = applicationContext)
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
            //     Screen(context = applicationContext)
        }
    }
}