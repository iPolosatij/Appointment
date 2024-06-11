package ru.animbus.appointment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                SetControlBtns()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SetControlBtns() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.padding(16.dp, 48.dp, 16.dp, 16.dp)){
                ElevatedButton(
                    onClick = {
                        val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                        intent.putExtra("url", "https://vitamed-rm.ru/visit/specialty")
                        startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.teal_200))
                ) {
                    Text(
                        text = "Запись Вита-Мед г.Саранск ",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            Row(modifier = Modifier.padding(all = 16.dp)){
                ElevatedButton(
                    onClick = {
                        val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                        intent.putExtra("url", "https://kim-rm.ru/appointment-to-doctor")
                        startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.teal_200))
                ) {
                    Text(
                        text = "Запись КИМ г.Саранск",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            Row(modifier = Modifier.padding(all = 16.dp)){
                ElevatedButton(
                    onClick = {
                        val intent = Intent(this@MainActivity, WebViewActivity::class.java)
                        intent.putExtra("url", "https://syst-assist.ru/site/index?area=95")
                        startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.teal_200))
                ) {
                    Text(
                        text = "Запись syst-assist ",
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.appointment_transparent),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .padding(0.dp, 64.dp, 0.dp, 0.dp)
            )
        }
    }
}
