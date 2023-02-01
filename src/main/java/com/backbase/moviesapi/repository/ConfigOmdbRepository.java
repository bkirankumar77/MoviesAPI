package com.backbase.moviesapi.repository;

import com.backbase.moviesapi.entity.ConfigOmdbEntity;
import com.backbase.moviesapi.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Configuration OMDB Repository
 */
public interface ConfigOmdbRepository extends JpaRepository<ConfigOmdbEntity, Integer> {

  ConfigOmdbEntity findFirstByType(Type type);
}
