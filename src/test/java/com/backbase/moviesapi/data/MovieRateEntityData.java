package com.backbase.moviesapi.data;


import com.backbase.moviesapi.entity.MovieEntity;
import com.backbase.moviesapi.entity.MovieRateEntity;
import com.backbase.moviesapi.entity.UserEntity;

public class MovieRateEntityData {

    public static MovieRateEntity movieRate = getMovieRateEntity();

    private static MovieRateEntity getMovieRateEntity(){
        return MovieRateEntity
                .builder()
                .movie(MovieEntity.builder().id(5).build())
                .user(UserEntity
                        .builder()
                        .id(5)
                        .username("Marie")
                        .build())
                .rate("2")
                .build();
    }
}
