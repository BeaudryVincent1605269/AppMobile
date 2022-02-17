package com.example.myapplication.core

import androidx.lifecycle.MutableLiveData

fun String.laMethodeYannick(): String {
    return "Vincent"
}

fun <T> MutableLiveData<T>.notify() {
    this.value = this.value
}