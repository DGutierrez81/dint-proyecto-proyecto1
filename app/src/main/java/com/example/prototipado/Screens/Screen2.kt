package com.example.prototipado.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.prototipado.Data.Routes
import com.example.prototipado.atalantico.Atalantico
import com.example.prototipado.cabecera.Cabecera
import com.example.prototipado.malaga.Malaga
import com.example.prototipado.piebueno.PieBueno
import com.example.prototipado.rutascosteras.RutasCosteras
import com.example.prototipado.sansebastian.SanSebastian



@Composable
fun Screen2(navController: NavHostController){
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
            LazyColumn{
                item {
                    RutasCosteras()
                    SanSebastian(Modifier.size(450.dp, 795.dp))
                    Malaga(Modifier.size(450.dp, 734.dp))
                Atalantico(
                    Modifier
                        .size(450.dp, 600.dp)
                        .padding(bottom = 100.dp))}
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