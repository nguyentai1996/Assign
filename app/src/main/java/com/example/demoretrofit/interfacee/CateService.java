package com.example.demoretrofit.interfacee;

import com.example.demoretrofit.model.Categories;
import com.example.demoretrofit.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CateService {
//    http://asian.dotplays.com/wp-json/wp/v2/categories?page=1&%20per_page=10
    @GET("wp-json/wp/v2/categories")
    Call<List<Categories>> getCate(@Query("page") String page,@Query("per_page") String per_page);
}
