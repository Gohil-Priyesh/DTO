package com.example.DTO.controller;

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

    @PostMapping("/create-without-dto")
    public ResponseEntity<EmployeeEntity> createEmployeeController(@RequestBody EmployeeEntity employeeEntity){
        employeeService.createEmployeeServiceWithoutDTO(employeeEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeDTO employee){

        employeeService.createEmployeeService(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get_all_users")
    public ResponseEntity<List<EmployeeEntity>> getAllUsers(){
        return new ResponseEntity<>(employeeService.getAllUsers(),HttpStatus.OK);
    }

//    @GetMapping("/similar_name")
//    public ResponseEntity<List<EmployeeEntity>> userWithSimilarNames(@PathParam("name")String name){
//
//        return new ResponseEntity<>(employeeService.findUsersByNameContaining(name),HttpStatus.OK);
//    }
}
