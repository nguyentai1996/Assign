package com.example.demoretrofit.interfacee;

import com.example.demoretrofit.model.Example;
import com.example.demoretrofit.model.GetPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostService {

    @GET("wp-json/wp/v2/media")
    Call<List<GetPost>> getPost(@Query("parent") String parent);
}
