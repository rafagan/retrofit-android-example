package com.rafagan.retrofitexample.kt

data class ToDoDTO(
    val userId: String,
    val id: String,
    val title: String,
    val completed: Boolean
)