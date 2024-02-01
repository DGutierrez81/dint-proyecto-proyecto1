package com.example.prototipado.Screens

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class Viewmodel: ViewModel() {
    private val _desplegable = MutableLiveData<Boolean>()
    val desplegable: LiveData<Boolean> = _desplegable
    private val _desplegable2 = MutableLiveData<Boolean>()
    val desplegable2: LiveData<Boolean> = _desplegable2
    var cambio by mutableStateOf(true)
    var cambio2 by mutableStateOf(true)



    fun vamos(cambiar: Boolean){
        cambio = !cambiar
        _desplegable.value = cambio
    }

    fun motos(cambiar: Boolean){
        cambio2 = !cambiar
        _desplegable2.value = cambio2
    }

}