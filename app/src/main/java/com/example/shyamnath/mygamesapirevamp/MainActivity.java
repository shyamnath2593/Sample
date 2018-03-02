package com.example.shyamnath.mygamesapirevamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.shyamnath.mygamesapirevamp.adapter.GamesListAdapter;
import com.example.shyamnath.mygamesapirevamp.model.GameDetailModel;
import com.example.shyamnath.mygamesapirevamp.model.GamesListModel;
import com.example.shyamnath.mygamesapirevamp.retrofit.ApiClient;
import com.example.shyamnath.mygamesapirevamp.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<GamesListModel> call=apiInterface.GAMES_LIST_MODEL_CALL("655446d0bf1056995c15f4a33b22d893","id,url,name","10");
        call.enqueue(new Callback<GamesListModel>() {
            @Override
            public void onResponse(Call<GamesListModel> call, Response<GamesListModel> response) {
                GamesListModel gamesListModel=response.body();
                GamesListAdapter adapter = new GamesListAdapter(MainActivity.this,gamesListModel.getSingleGame());

                RecyclerView recyclerView= findViewById(R.id.recyclerView);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getApplicationContext(),2);
                recyclerView.setLayoutManager(layoutManager);

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<GamesListModel> call, Throwable t) {
                Log.e("act",t.getMessage());
            }
        });
    }
}
