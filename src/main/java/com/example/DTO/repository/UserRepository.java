package com.example.DTO.repository;

import com.example.DTO.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/// repository talk with DB
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

  Optional<UserEntity> findById(Integer id);
}
