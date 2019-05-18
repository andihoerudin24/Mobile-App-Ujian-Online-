package com.tutorkomputer.ujianonlinerevisi.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tutorkomputer.ujianonlinerevisi.data.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Retrofit retrofit = null;

    public static Retrofit getUrl(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

         retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

          return retrofit;
    }
}
