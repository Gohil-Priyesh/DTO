package com.example.DTO.service;

import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void createEmployeeServiceWithoutDTO(EmployeeEntity employeeEntity);

     EmployeeEntity createEmployeeService(EmployeeDTO employeeDTO);

     List<EmployeeEntity> getAllUsers();

//    List<EmployeeDTO> findUsersByNameContaining(String name);
}
