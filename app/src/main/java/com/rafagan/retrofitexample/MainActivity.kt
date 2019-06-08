package com.rafagan.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rafagan.retrofitexample.kt.ToDoService

class MainActivity : AppCompatActivity() {
    lateinit var service: ToDoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service = ToDoService()
        service.getToDos({ toDos ->
            toDos?.forEach {
                Log.d("api_todo", it.toString())
            }
        }, {
            Log.e("api_error", it.toString())
        })
    }
}
