package com.example.DTO.repository;

import com.example.DTO.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findAll();

    Optional<OrderEntity> findById(Integer id);
}
