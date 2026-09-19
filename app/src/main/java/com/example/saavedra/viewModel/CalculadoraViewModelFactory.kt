package com.example.saavedra.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.saavedra.repository.OperacionRepository

class CalculadoraViewModelFactory(
    private val repository: OperacionRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (
            modelClass.isAssignableFrom(
                CalculadoraViewModel::class.java
            )
        ) {

            @Suppress("UNCHECKED_CAST")
            return CalculadoraViewModel(
                repository
            ) as T
        }

        throw IllegalArgumentException(
            "ViewModel desconocido: ${modelClass.name}"
        )
    }


}