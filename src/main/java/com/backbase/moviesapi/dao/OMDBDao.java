package com.backbase.moviesapi.dao;


import com.backbase.moviesapi.dto.Example;
import java.io.IOException;
import java.util.Optional;

/**
 * @author KB
 * @version 0.0.1
 * <p>
 * OMDB DAO
 */
public interface OMDBDao {

    Optional<Example> findByTitleAndType(String title, String type) throws IOException;

    Optional<byte[]> findImageByIMDB(String imdb) throws IOException;

}
