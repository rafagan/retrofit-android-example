package com.rafagan.retrofitexample.java;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.rafagan.retrofitexample.R;
import okhttp3.ResponseBody;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ToDoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        service = new ToDoService();
        service.getToDos(new DefaultCallback.OnSuccess<List<ToDoDTO>>() {
            @Override
            public void run(List<ToDoDTO> data) {
                for(ToDoDTO dto: data) {
                    Log.d("api_todo", dto.toString());
                }
            }
        }, new DefaultCallback.OnError() {
            @Override
            public void run(ResponseBody errorBody) {
                Log.e("api_error", errorBody.toString());
            }
        });
    }
}
