package com.example.prototipado.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.prototipado.Data.Routes
import com.example.prototipado.cabecera.Cabecera
import com.example.prototipado.harley.Harley
import com.example.prototipado.motosazul.MotosAzul

import com.example.prototipado.motose.MotosE
import com.example.prototipado.piebueno.PieBueno
import com.example.prototipado.portada.Portada
import com.example.prototipado.rutas.Design
import com.example.prototipado.motose.Design.Default11
import com.example.prototipado.motose.Design.Default22
import com.example.prototipado.rutas.Rutas
import com.example.prototipado.rutasazul.RutasAzul


@Composable
fun Screen1(navController: NavHostController, viewModel: Viewmodel){
    val desplegable: Boolean by viewModel.desplegable.observeAsState(false)
    val desplegable2: Boolean by viewModel.desplegable2.observeAsState(false)
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()){
        val (box1, box2, box3,box4) = createRefs()
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
            Portada(Modifier.size(360.dp, 462.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.padding(30.dp)) {
                    if(desplegable) RutasAzul(Modifier.size(100.dp, 40.dp),{viewModel.vamos(desplegable)}) else Rutas(Modifier.size(100.dp, 40.dp), Design.Default1, { viewModel.vamos(desplegable) })
                    if(desplegable) Rutas(
                        Modifier
                            .size(100.dp, 40.dp)
                            .padding(top = 35.dp), Design.Default2, { viewModel.vamos(desplegable) }, { navController.navigate(
                        Routes.Screen2.routes)
                        viewModel.vamos(desplegable)},
                        { navController.navigate(
                            Routes.Screen3.routes)
                            viewModel.vamos(desplegable)})
                }
                Column(Modifier.padding(30.dp)) {
                    if(desplegable2) MotosAzul(Modifier.size(100.dp, 40.dp),{viewModel.motos(desplegable2)}) else MotosE(Modifier.size(100.dp, 40.dp), Default11, {viewModel.motos(desplegable2)})
                    if(desplegable2)  MotosE(Modifier.size(100.dp, 40.dp).padding(top = 55.dp), Default22, {viewModel.motos(desplegable2)}, { navController.navigate(
                        Routes.Screen4.routes)
                        viewModel.motos(desplegable2)
                    })
                }
            }
        }
        Box(modifier = Modifier.
        constrainAs(box3){
            top.linkTo(box2.bottom)
        }){

            LazyRow{
                    item { Harley(Modifier.size(3214.dp, 270.dp)) }
            }




        }
        Box(modifier = Modifier
            .constrainAs(box4){
                bottom.linkTo(parent.bottom)
            }) {
            PieBueno()
        }
    }
}