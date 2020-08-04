package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.httplibrary.HttpManager;
import com.example.httplibrary.callback.HttpCallBack;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.service.ApiServer;
import com.example.httplibrary.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("project/tree/json")
                .build()
                .request(new HttpCallBack<Shitilei>() {


                    @Override
                    public void onSuccess(Shitilei shitilei) {
                        Log.e("111",shitilei.toString());
                    }

                    @Override
                    public Shitilei convert(JsonElement result) {

//                        return JsonUtils.jsonToClassList(result, Shitilei.class);
                        Shitilei shitilei = new Gson().fromJson(new Gson().toJson(result), Shitilei.class);
                        return shitilei;
                    }

                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }
                });

    }
}
