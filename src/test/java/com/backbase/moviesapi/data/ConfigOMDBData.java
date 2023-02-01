package com.backbase.moviesapi.data;
import com.backbase.moviesapi.entity.ConfigOmdbEntity;
import com.backbase.moviesapi.enums.Type;
import java.time.LocalDateTime;

public class ConfigOMDBData {

    public static ConfigOmdbEntity configOmdb = getConfigOmdbMovie();

    public static ConfigOmdbEntity actorConfigOmdb = getActorConfigOmdb();

    public static ConfigOmdbEntity seriesConfigOmdb = getSeriesConfigOmdb();


    private static ConfigOmdbEntity getConfigOmdbMovie() {
        return ConfigOmdbEntity
                .builder()
                .id(1)
                .type(Type.MOVIE)
                .enable(true)
                .createdAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    private static ConfigOmdbEntity getActorConfigOmdb() {
        return ConfigOmdbEntity
                .builder()
                .type(Type.ACTOR)
                .enable(false)
                .createdAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }

    private static ConfigOmdbEntity getSeriesConfigOmdb() {
        return ConfigOmdbEntity
                .builder()
                .id(3)
                .type(Type.SERIES)
                .enable(true)
                .createdAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(java.sql.Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
