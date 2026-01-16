package com.example.DTO.controller;

import com.example.DTO.ApiResponse;
import com.example.DTO.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/user_order/{id}")
    public ResponseEntity<?> getUserOrder(@PathVariable Integer id){

        return ResponseEntity.ok(new ApiResponse<>(200,orderService.getOrderById(id)));
    }

}
