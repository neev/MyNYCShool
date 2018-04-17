package com.neeruap.mynycshool.Util;

import com.neeruap.mynycshool.Retrofit.RetrofitApiClient;
import com.neeruap.mynycshool.Retrofit.RetrofitApiInterface;

public class NYCApiCallRequest {

    public static String BASE_URL = "https://data.cityofnewyork.us/";
    public static String API_KEY = "w0vgoP77zpe4CmHt95yMuWyg7";

    public static RetrofitApiInterface getRetroApiClient() {
        return RetrofitApiClient.getRetrofitClient(BASE_URL).create(RetrofitApiInterface.class);
    }
}
