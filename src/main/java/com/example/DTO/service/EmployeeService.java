package com.example.DTO.service;

import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.dto.EmployeeDetailsDTO;
import com.example.DTO.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

     EmployeeEntity createEmployeeService(EmployeeDTO employeeDTO);

     List<EmployeeDTO> getAllUsers();

     EmployeeDetailsDTO findUsersByNameContaining(String name);
}
