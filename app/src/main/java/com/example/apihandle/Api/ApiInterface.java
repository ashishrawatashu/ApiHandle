package com.example.apihandle.Api;

import com.example.apihandle.ModelClass.CountryResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("common/GetCountry")
    Call<CountryResponse> getCountryApi();

    @GET("common/GetCountry")
    Call<JsonObject> getCountry();
}
