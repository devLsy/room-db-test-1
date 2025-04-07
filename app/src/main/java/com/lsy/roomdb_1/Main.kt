package com.lsy.roomdb_1

import androidx.compose.runtime.mutableStateOf

fun main() {
//    println("Hello, World!")


    val count = mutableStateOf(0)
    println(count.value)
    count.value = 20
    println(count.value)
}


