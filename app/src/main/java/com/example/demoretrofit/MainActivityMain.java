package com.example.demoretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.demoretrofit.Retrofit.PolyRetrofit;
import com.example.demoretrofit.Retrofit.PostRetrofit;
import com.example.demoretrofit.adapter.AdapterRCV;
import com.example.demoretrofit.adapter.AdapterRCVvolleyMain;
import com.example.demoretrofit.model.Example;
import com.example.demoretrofit.model.GetPost;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityMain extends AppCompatActivity {



    List<GetPost> getpostList = new ArrayList<>();
    private RecyclerView rcvExample;
    private AdapterRCVvolleyMain adapterRCV;
    int curentPage;
    int lastVisibleItem, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        curentPage = 1;
        adapterRCV = new AdapterRCVvolleyMain(getpostList);
        rcvExample = (RecyclerView) findViewById(R.id.rcv_example);
        rcvExample.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvExample.setAdapter(adapterRCV);
        demoRetrofitMain(curentPage);


    }


    public void demoRetrofitMain(int curentPage) {
        PostRetrofit.getInstance().getPost("377")
                .enqueue(new Callback<List<GetPost>>() {
                    @Override
                    public void onResponse(Call<List<GetPost>> call, Response<List<GetPost>> response) {
                        if (response.code() == 200 && response.body() != null) {

                            adapterRCV.updateData(response.body());
                        } else {
                            Toast.makeText(MainActivityMain.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GetPost>> call, Throwable t) {
                        Log.e("err", t.getMessage());
                    }
                });
    }
}
