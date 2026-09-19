package com.example.saavedra

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.saavedra.ui.theme.SaavedraTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberWideNavigationRailState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.saavedra.data.local.CalculadoraDatabase
import kotlin.concurrent.timer
import com.example.saavedra.interfaz.CalculadoraScreen
import com.example.saavedra.interfaz.componentes.BotonCalculadora
import com.example.saavedra.repository.OperacionRepository
import com.example.saavedra.viewModel.CalculadoraViewModel
import com.example.saavedra.viewModel.CalculadoraViewModelFactory

class MainActivity : ComponentActivity() {
    private val database by lazy {
        CalculadoraDatabase.getDatabase(applicationContext)
    }
    private val repository by lazy {
        OperacionRepository(
            database.operacionDao()
        )
    }
    private val CalculadoraViewModel: CalculadoraViewModel by viewModels {
        CalculadoraViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                CalculadoraScreen(CalculadoraViewModel)
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

/*@Composable
fun PantallaCalculadora(modifier: Modifier) {
    //esta fue mi primera practica
    /*val calculadora = Calculadora(
        num1 = 10.0,
        num2 = 5.0
    )*/
    /*Column {
        Text("Calculadora")
        Text("Numero 1: 15")
        Text("Numero 2: 5")
        Text("Resultados: ${calculadora.sumar()}")
        Text("Resultados: ${calculadora.restar()}")
        Text("Resultados: ${calculadora.multiplicar()}")
        Text("Resultados: ${calculadora.dividir()}")
    }*/
    var num1 by remember {
        mutableStateOf("5")
    }
    var num2 by remember {
        mutableStateOf("10")
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            val n1 = num1.toInt()
            val n2 = num2.toInt()
            n1+n2
            val resultado =
                num1.toInt() + num2.toInt()
            Log.d(
                "MI_APP",
                "Resultado: $resultado"
            )
        }) {
            Text("Sumar")
        }
    }
}
    //Esta fue mi segunda practica
    /*Column {
        Button(
        onClick = {
            Log.d("Mi_APP","El usuario presiono el Boton")
        }
    ) {
        Text("Probar LogCat")
        }
    }*/
    /*var contador by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Contador",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "$contador",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                contador++
                Log.d("Mi_APP", "Contador_Actual=$contador")
            },modifier = Modifier.height(50 .dp).width(300.dp)
        ) {
            Text("Click")
        }
    }*/
@Composable
fun PantallaCalculadora(modifier: Modifier) {
    //Variables
    var numero1 by remember {
        mutableStateOf("")
    }
    var numero2 by remember {
        mutableStateOf("")

    }
    var resultado by remember {
        mutableStateOf(0)
    }

    //Columna
    Column(
        modifier = modifier.fillMaxSize().padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = "Calculadora",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
        )
        Spacer(
            modifier = Modifier.height(100.dp)
        )
        TextField(
            value = numero1,
            onValueChange = { numero1 = it},
            label = { Text ("Numero 1")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        //Espacios
        Spacer(
            modifier = Modifier.height(10.dp)
        )

        TextField(
            value = numero2,
            onValueChange = { numero2 = it},
            label = { Text ("Numero 2")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            text = "Resultado: $resultado",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        //Se agrego Row para agrupar los botones
        Row() {
            //Boton Suma
            Button(
                onClick = {
                    resultado =
                        numero1.toInt() +
                                numero2.toInt()
                    Log.d(
                        "Mi_APP",
                        "Resultado= $resultado",

                        )
                },
                modifier = Modifier
                .weight(1f)
                .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFDD03)
                ),
                enabled = numero1.isNotEmpty() && numero2.isNotEmpty(),
            )
            {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sumar", color = Color.Black)
            }
            /*{
                Text("Sumar")
            }*/

            //Espacios
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            //Boton Restar
            Button(
                onClick = {
                    resultado =
                        numero1.toInt() -
                                numero2.toInt()
                    Log.d(
                        "Mi_APP",
                        "Resultado= $resultado",

                        )
                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF0000)
                ),
                enabled = numero1.isNotEmpty() && numero2.isNotEmpty(),
            )
            {
                Text("Restar")
            }
        }
        Spacer(
                modifier = Modifier.height(10.dp)
                )
        Row() {
            //Multiplicar
            Button(
                onClick = {
                    resultado =
                        numero1.toInt() *
                                numero2.toInt()
                    Log.d(
                        "Mi_APP",
                        "Resultado= $resultado",

                        )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6AFF00)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                enabled = numero1.isNotEmpty() && numero2.isNotEmpty(),
            )
            {
                Text("Multiplicar")
            }
            //Espacios
            Spacer(
                modifier = Modifier.height(25.dp)
            )

            //Dividir
            Button(
                onClick = {
                    val n1 = numero1.toIntOrNull() ?: 0
                    val n2 = numero2.toIntOrNull() ?: 0

                    if (n2 != 0) {
                        resultado = n1 / n2
                        Log.d("Mi_APP", "Resultado= $resultado")
                    } else {
                        Log.d("Mi_APP", "Error: División por cero")
                        // Podrías poner resultado = 0 o manejarlo de otra forma
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFCCFF84)
                ),
                enabled = numero1.isNotEmpty() && numero2.isNotEmpty() && numero2 != "0",
            )
            {
                Text("Dividir")
            }
        }
        //Boton Limpiar
        Button(
            onClick = {
                numero1 = ""
                numero2 = ""
                resultado = 0
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF350393)
            ),
            enabled = numero1.isNotEmpty() or numero2.isNotEmpty()
        )

        {
            Text("limpiar")
        }
        }
    }
*/