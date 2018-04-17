package com.neeruap.mynycshool.Retrofit;

import com.neeruap.mynycshool.Util.MyNYCSchoolLogs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(String baseUrl) {
        MyNYCSchoolLogs.d("getRetrofitClient() is called");
        MyNYCSchoolLogs.d(baseUrl);
        if (retrofit==null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
