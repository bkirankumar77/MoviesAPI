package com.backbase.moviesapi.service;
import com.backbase.moviesapi.data.MovieEntityData;
import com.backbase.moviesapi.data.MovieRateEntityData;
import com.backbase.moviesapi.entity.MovieEntity;
import com.backbase.moviesapi.entity.MovieRateEntity;
import com.backbase.moviesapi.repository.MovieRateRepository;
import com.backbase.moviesapi.repository.MovieRepository;
import com.backbase.moviesapi.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class MovieRateServiceTest {

    @InjectMocks
    private MovieRateService movieRateService;

    @Mock
    private MovieRateRepository movieRateRepository;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private UserRepository userRepository;

    @Spy
    private MovieEntity ratatouilleMovieEntity = MovieEntityData.ratatouilleEntity;

    @Spy
    private MovieRateEntity movieRate = MovieRateEntityData.movieRate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Rate Movie ")
    void rateMovie() {
        Mockito.doReturn(Optional.of(ratatouilleMovieEntity)).when(movieRepository)
                .findByImdbId("tt0382932");
        movieRateService.rateMovie("tt0382932", "1", "nancy");
    }


}
