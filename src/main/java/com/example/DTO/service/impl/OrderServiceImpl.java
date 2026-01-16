package com.example.DTO.service.impl;

import com.example.DTO.dto.OrderDTO;
import com.example.DTO.mapper.OrderMapper;
import com.example.DTO.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements com.example.DTO.service.OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDTO getOrderById(Integer id){
       return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElse(new OrderDTO());
    }
}
