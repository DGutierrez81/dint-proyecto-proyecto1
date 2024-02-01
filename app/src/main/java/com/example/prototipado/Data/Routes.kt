package com.example.prototipado.Data

sealed class Routes(val routes: String) {
    object Screen1: Routes("screen1")

    object Screen2: Routes("screnn2")

    object Screen3: Routes("screnn3")

    object Screen4: Routes("screnn4")
}