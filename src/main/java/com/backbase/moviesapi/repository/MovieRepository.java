package com.backbase.moviesapi.repository;

import com.backbase.moviesapi.entity.MovieEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MovieRepository
 *
 * @author KB
 * @version 0.0.1
 */
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    Optional<MovieEntity> findByImdbId(String imdbId);

}
