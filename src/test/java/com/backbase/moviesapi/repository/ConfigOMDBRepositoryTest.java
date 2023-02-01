package com.backbase.moviesapi.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import com.backbase.moviesapi.data.ConfigOMDBData;
import com.backbase.moviesapi.enums.Type;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ConfigOMDBRepositoryTest {

    @Mock
    private ConfigOmdbRepository configOmdbRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Find Movie by title and type ")
    void findMovieByTitleAndType() {
        doReturn(ConfigOMDBData.configOmdb).when(configOmdbRepository).findFirstByType(Type.MOVIE);
        var movieConfig = configOmdbRepository.findFirstByType(Type.MOVIE);
        assertNotNull(movieConfig);
        assertEquals(1, movieConfig.getId());
    }

    @Test
    @DisplayName("Save actor config")
    void saveActorConfig() {
        var actorConfigOmdb = ConfigOMDBData.actorConfigOmdb;
        var expectedResponse = actorConfigOmdb;
        expectedResponse.setId(2);
        expectedResponse.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        doReturn(expectedResponse).when(configOmdbRepository).save(actorConfigOmdb);
        var actualResponse = configOmdbRepository.save(actorConfigOmdb);
        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get movie config")
    void getMovieConfig() {
        var movieConfig = ConfigOMDBData.configOmdb;
        doReturn(Optional.of(movieConfig)).when(configOmdbRepository).findById(1);
        var response = configOmdbRepository.findById(1);
        assertTrue(response.isPresent());
        assertEquals(movieConfig, response.get());
    }

    @Test
    @DisplayName("Get director config")
    void getDirectorConfig() {
        doReturn(null).when(configOmdbRepository).findFirstByType(Type.valueOf("DIRECTOR"));
        var response = configOmdbRepository.findFirstByType(Type.valueOf("DIRECTOR"));
        assertNull(response);
    }

}
