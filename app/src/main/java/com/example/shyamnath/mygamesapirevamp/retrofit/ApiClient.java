package com.example.shyamnath.mygamesapirevamp.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shyamnath on 08-12-2017.
 */

public class ApiClient {


    public static Retrofit getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-2445582011268.apicast.io/games/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
