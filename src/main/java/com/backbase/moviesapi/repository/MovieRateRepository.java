package com.backbase.moviesapi.repository;

import com.backbase.moviesapi.entity.MovieRateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * MovieRateRepository
 *
 * @author KB
 * @version 0.0.1
 */
public interface MovieRateRepository extends JpaRepository<MovieRateEntity, Integer> {

    @Query("select m from MovieRateEntity m where m.movie.imdbId =:imdbId and m.user.username =:username")
    Optional<MovieRateEntity> getMovieRateByMovieImdbIdAndUsername(@Param("imdbId") String imdbId , @Param("username") String username);

}
