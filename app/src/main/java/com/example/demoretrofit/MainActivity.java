package com.example.demoretrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.demoretrofit.Retrofit.PolyRetrofit;
import com.example.demoretrofit.adapter.AdapterRCV;
import com.example.demoretrofit.model.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    List<Example> exampleList = new ArrayList<>();
    private RecyclerView rcvExample;
    private AdapterRCV adapterRCV;
    int curentPage;
    int lastVisibleItem, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        curentPage = 1;
        adapterRCV = new AdapterRCV(exampleList);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        rcvExample = (RecyclerView) findViewById(R.id.rcv_example);
        rcvExample.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcvExample.setAdapter(adapterRCV);
        demoRetro(curentPage);

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rcvExample.getLayoutManager();
        rcvExample.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (linearLayoutManager != null) {
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                }
                totalItemCount = Integer.parseInt(String.valueOf(rcvExample.getAdapter().getItemCount()));
                if (!rcvExample.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    curentPage++;
                    demoRetro(curentPage);

                }
            }
        });

    }

    public void demoRetro(int curentPage) {
        PolyRetrofit.getInstance().getPost("")
                .enqueue(new Callback<List<Example>>() {
                    @Override
                    public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                        if (response.code() == 200 && response.body() != null) {
                            adapterRCV.updateData(response.body());
                        } else {
                            Toast.makeText(MainActivity.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Example>> call, Throwable t) {
                        Log.e("err", t.getMessage());
                    }
                });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lastest) {
            // Handle the camera action
        } else if (id == R.id.nav_category) {

        } else if (id == R.id.nav_gifs) {

        } else if (id == R.id.nav_favorite) {

        } else if (id == R.id.nav_rate) {

        } else if (id == R.id.nav_moreapp) {

        } else if (id == R.id.nav_about) {
        } else if (id == R.id.nav_setting) {
        } else if (id == R.id.nav_privacy) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
