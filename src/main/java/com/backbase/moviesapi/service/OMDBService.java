package com.backbase.moviesapi.service;


import com.backbase.moviesapi.dao.OMDBDaoImpl;
import com.backbase.moviesapi.dto.Example;
import java.io.IOException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @version 0.0.1
 * @author KB
 *
 * OMDB Service
 */
@Service
@RequiredArgsConstructor
public class OMDBService {

    private final OMDBDaoImpl omdbDaoImpl;

    public Optional<Example> getOMDBByTitleAndType(String title, String type) throws IOException {
        return omdbDaoImpl.findByTitleAndType(title, type);
    }

    public Optional<byte[]> getImageByIMDB(String imdb) throws IOException {
        return omdbDaoImpl.findImageByIMDB(imdb);
    }

}
