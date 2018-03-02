package com.example.shyamnath.mygamesapirevamp.retrofit;

import com.example.shyamnath.mygamesapirevamp.model.GamesListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Shyamnath on 08-12-2017.
 */

public interface ApiInterface {
    @GET("games/")
    Call<GamesListModel>GAMES_LIST_MODEL_CALL(@Header("user-key")String key, @Query("fields")String fieldsNeeded,@Query("limit") String limit);
}
