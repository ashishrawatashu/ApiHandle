package com.example.apihandle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.apihandle.Api.ApiClient;
import com.example.apihandle.Api.ApiResponse;
import com.example.apihandle.Api.ApiService;
import com.example.apihandle.ModelClass.CountryResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ApiResponse {
    CountryResponse stateResponse;
    CountryResponse stateResponse1;

    //newww navjeet committ
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService<CountryResponse> service = new ApiService<>();
        service.get(this, ApiClient.getApiInterface().getCountryApi(), "GetCountry");

        ApiService<JsonObject> service1 = new ApiService<>();
        service1.get(this, ApiClient.getApiInterface().getCountry(), "GetCountry1");
    }

    @Override
    public void onResponse(Response response, String key) {
        switch (key) {
            case "GetCountry":
                try {
                    Gson gson = new Gson();
                    stateResponse = (CountryResponse) response.body();
                    Log.e("GET_COUNTRY", gson.toJson(stateResponse));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "GetCountry1":
                try {
                    JsonObject getCountry1 = (JsonObject) response.body();
                    Log.e("GET_COUNTRY_1", getCountry1.toString());
                    JsonObject getCountry1response = getCountry1.getAsJsonObject("response");
                    Log.e("RESPONSE", getCountry1response.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onError(Throwable t, String key) {

    }
}