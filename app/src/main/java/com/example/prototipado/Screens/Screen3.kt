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
import com.example.prototipado.alpujarra.Alpujarra
import com.example.prototipado.cabecera.Cabecera
import com.example.prototipado.picos.Picos
import com.example.prototipado.piebueno.PieBueno
import com.example.prototipado.rutassierra.RutasSierra
import com.example.prototipado.tajo.Tajo

@Composable
fun Screen3(navController: NavHostController){
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
                    RutasSierra()
                    Picos(Modifier.size(450.dp, 795.dp))
                    Alpujarra(Modifier.size(450.dp, 600.dp))
                    Tajo(Modifier.size(450.dp, 750.dp).padding(bottom = 150.dp))

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