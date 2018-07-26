package com.vikcandroid.retrofit101.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String API_BASE_URL = "https://api.github.com";


    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder hBuilder = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        if (!hBuilder.interceptors().contains(loggingInterceptor)) {
            hBuilder.addInterceptor(loggingInterceptor);
            builder = builder.client(hBuilder.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}
