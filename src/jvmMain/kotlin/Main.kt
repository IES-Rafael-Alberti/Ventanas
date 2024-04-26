import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun main() {
    var mainWindowVisible by remember { mutableStateOf(true) }
    var secondWindowVisible by remember { mutableStateOf(false) }

    while (mainWindowVisible || secondWindowVisible) {
        if (mainWindowVisible) {
            MainWindow(
                onClose = { mainWindowVisible = false },
                onButtonClick = {
                    mainWindowVisible = false
                    secondWindowVisible = true
                }
            )
        }
        if (secondWindowVisible) {
            SecondWindow(
                onClose = { secondWindowVisible = false },
                onButtonClick = {
                    secondWindowVisible = false
                    mainWindowVisible = true
                }
            )
        }
    }
    exitApplication()
}

@Composable
fun MainWindow(
    onClose: () -> Unit,
    onButtonClick: () -> Unit
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ventana principal")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onButtonClick) {
                Text("Abrir ventana secundaria")
            }
        }
    }
}

@Composable
fun SecondWindow(
    onClose: () -> Unit,
    onButtonClick: () -> Unit
) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ventana secundaria")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onButtonClick) {
                Text("Volver a la ventana principal")
            }
        }
    }
}

fun exitApplication() {
    println("Saliendo de la aplicación...")
    System.exit(0)
}



