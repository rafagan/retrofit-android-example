package com.rafagan.retrofitexample.java;

import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class DefaultCallback<T> implements Callback<T> {
    public interface OnSuccess<T> {
        void run(T data);
    }

    public interface OnError {
        void run(ResponseBody errorBody);
    }

    private final OnSuccess<T> onSuccess;
    private final OnError onError;

    public DefaultCallback(OnSuccess<T> onSuccess, OnError onError) {
        this.onSuccess = onSuccess;
        this.onError = onError;
    }

    @Override
    public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
        if(response.isSuccessful()) {
            onSuccess.run(response.body());
        } else {
            onError.run(response.errorBody());
        }
    }
}
