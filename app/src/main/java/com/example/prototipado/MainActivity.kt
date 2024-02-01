package com.example.prototipado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prototipado.Data.Routes
import com.example.prototipado.Screens.Screen1
import com.example.prototipado.Screens.Screen2
import com.example.prototipado.Screens.Screen3
import com.example.prototipado.Screens.Screen4
import com.example.prototipado.Screens.Viewmodel
import com.example.prototipado.ui.theme.PrototipadoTheme


class MainActivity : ComponentActivity() {
    private val viewmodel: Viewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrototipadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.Screen1.routes){
                        composable(Routes.Screen1.routes){ Screen1(navController, viewmodel) }
                        composable(Routes.Screen2.routes){ Screen2(navController)}
                        composable(Routes.Screen3.routes){ Screen3(navController)}
                        composable(Routes.Screen4.routes){ Screen4(navController)}
                    }
                }
            }
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrototipadoTheme {
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
                Rutas(Modifier.size(100.dp, 40.dp))
            }
            Box(modifier = Modifier
                .constrainAs(box3){
                    bottom.linkTo(parent.bottom)
                }) {
                PieBueno()
            }
        }
    }
}

 */


