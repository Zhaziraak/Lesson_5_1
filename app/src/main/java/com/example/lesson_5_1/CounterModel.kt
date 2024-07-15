package com.example.lesson_5_1

class CounterModel {
    private var count = 0

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }

    fun getResult() = count
}