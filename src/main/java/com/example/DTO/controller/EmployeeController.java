package com.example.DTO.controller;

import com.example.DTO.ApiResponse;
import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.entity.EmployeeEntity;
import com.example.DTO.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employee){

        employeeService.createEmployeeService(employee);
        return new ResponseEntity<>(201,HttpStatus.CREATED);
    }

    @GetMapping("/get_all_users")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(new ApiResponse<>(200,employeeService.getAllUsers()));
    }

    @GetMapping("/similar_name")
    public ResponseEntity<?> userWithSimilarNames(@PathParam("name")String name){

        return ResponseEntity.ok(new ApiResponse<>(200,employeeService.findUsersByNameContaining(name)));
    }
}
