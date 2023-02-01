package com.backbase.moviesapi.dao;

import com.backbase.moviesapi.dto.Example;
import com.backbase.moviesapi.security.OMDBClientInstance;
import com.backbase.moviesapi.utils.UrlGenerator;
import java.io.IOException;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author KB
 * @version 0.0.1
 */
@Slf4j
@Repository
public class OMDBDaoImpl implements OMDBDao {

    @Autowired
    private  RestTemplate restTemplate;
    @Autowired
    private  UrlGenerator urlGenerator;


    /**
     * Find Movie from 3rd party by title
     *
     * @param title
     * @param type
     * @return
     * @throws IOException
     */
    @Override
    public Optional<Example> findByTitleAndType(String title, String type) throws IOException {
        log.info(">>> OMDBDaoImpl >> findByTitleAndType >> title: " + title + " type :" + type);
        final var response = restTemplate.getForEntity(urlGenerator.generateUrl(title), Example.class);
        final var example = response.getBody();
        log.info(" urlGenerator :" + urlGenerator.generateUrl(title));
        log.info(" example :" + example.toString());
        log.info("<<< OMDBDaoImpl << findByTitleAndType << output: " + example.getImdbID());
        return example.getResponse().equals("False") ?
            Optional.empty() :
            Optional.of(example);
    }
    /**
     * Find portal image movie by IMDB
     *
     * @param imdb
     * @return
     * @throws IOException
     */
    @Override
    public Optional<byte[]> findImageByIMDB(String imdb) throws IOException {
        log.info(">>> OMDBDaoImpl >> findImageByIMDB >> IMDBID: " + imdb);
        Retrofit retrofitInstance = OMDBClientInstance.getRetrofitImgInstance();
        OMDBRetrofitDao omdbRetrofitDao = retrofitInstance.create(OMDBRetrofitDao.class);
        Call<ResponseBody> call = omdbRetrofitDao.findImageByIMDB(imdb);
        Response<ResponseBody> execute = call.execute();
        try {
            ResponseBody responseBody = execute.body();
            if (responseBody == null) return Optional.empty();
            return Optional.of(responseBody.bytes());
        }catch (Exception e) {
            log.error(">>> OMDBDaoImpl >> findImageByIMDB >>  Error on read image for movie :"+imdb, e.getMessage());
            return Optional.empty();
        } finally {
            log.info("<<< OMDBDaoImpl << findImageByIMDB ");
        }
    }

}

