package com.neeruap.mynycshool.Retrofit;

import com.neeruap.mynycshool.Model.School;
import com.neeruap.mynycshool.Model.SchoolSATscore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApiInterface {
    @GET("/resource/97mf-9njv.json/")
    Call<List<School>> getSchools(@Query("$$app_token") String apiKey,
                                  @Query("$limit") int limit,
                                  @Query("$offset") int offset);

    @GET("/resource/734v-jeq5.json/")
    Call<List<SchoolSATscore>> getSchoolsSATscore(
            @Query("$$app_token") String apiKey,
            @Query("dbn") String dbn);

    @GET("/resource/97mf-9njv.json/")
    Call<List<School>> getSearchSchool(@Query("$$app_token") String apiKey,
                                        @Query("borough") String borough,
                                        @Query("$limit") int limit,
                                        @Query("$offset") int offset);
}
