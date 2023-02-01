package com.backbase.moviesapi.repository;

import com.backbase.moviesapi.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findFirstByUsername(String username);
}
