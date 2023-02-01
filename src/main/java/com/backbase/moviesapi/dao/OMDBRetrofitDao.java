package com.backbase.moviesapi.dao;

import com.backbase.moviesapi.dto.Example;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author KB
 * <p>
 * OMDB retrofit client DAO
 * @version 0.0.1
 */
public interface OMDBRetrofitDao {

    @GET("/")
    Call<Example> findByTitleAndType(@Query("t") String title, @Query("type") String type);

    @GET("/")
    Call<ResponseBody> findImageByIMDB(@Query("i") String imdb);
}
