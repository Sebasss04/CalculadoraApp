package com.example.saavedra.interfaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import com.example.saavedra.interfaz.CalculadoraScreen
import com.example.saavedra.interfaz.componentes.BotonCalculadora
import com.example.saavedra.interfaz.componentes.DisplayCalculadora
import com.example.saavedra.interfaz.componentes.TecladoCalculadora
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.saavedra.interfaz.componentes.NavbarCalculadora
import com.example.saavedra.ui.theme.AccentLilac
import com.example.saavedra.ui.theme.SurfaceLight
import com.example.saavedra.ui.theme.TextPrimary
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.saavedra.viewModel.CalculadoraViewModel

@Composable
fun CalculadoraScreen(viewModel: CalculadoraViewModel) {
    Scaffold(
        topBar = {
            NavbarCalculadora(
                onMenuClick = {
                },
                onMoreClick = {
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp, 48.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DisplayCalculadora(viewModel.valor)

            TecladoCalculadora(
                onNumeroClick = { numero ->
                    viewModel.numero(numero)
                },
                onOperacionClick = { operacion ->
                    viewModel.operacion(operacion)
                },
                onIgualClick = {
                    viewModel.igual()
                },
                onLimpiarClick = {
                    viewModel.limpiar()
                }
            )
        }

    }
}