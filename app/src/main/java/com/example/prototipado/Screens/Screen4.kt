package com.example.prototipado.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.prototipado.Data.Routes
import com.example.prototipado.cabecera.Cabecera
import com.example.prototipado.listamotos.ListaMotos
import com.example.prototipado.piebueno.PieBueno

@Composable
fun Screen4(navController: NavHostController){
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()){
        val (box1, box2, box3) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(box1){
                    top.linkTo(parent.top)
                }
        ) {
            Cabecera(Modifier.size(450.dp, 60.dp))
        }
        Box(
            modifier = Modifier
                .constrainAs(box2){
                    top.linkTo(box1.bottom)
                }
        ) {
            LazyRow{
                item {
                   ListaMotos(
                       Modifier
                           .size(1230.dp, 1000.dp)
                           .padding(bottom = 120.dp)
                           .verticalScroll(rememberScrollState()))

                }
            }
        }
        Box(modifier = Modifier
            .constrainAs(box3){
                bottom.linkTo(parent.bottom)
            }) {
            PieBueno(Modifier) {
                navController.navigate(
                    Routes.Screen1.routes
                )
            }
        }
    }
}