import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import view.mainView

@Composable
@Preview
fun App() {



}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        //App()
        val main = mainView()
        main.mainStart()
    }
}