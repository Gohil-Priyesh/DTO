package com.example.DTO.service.impl;

import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.dto.EmployeeDetailsDTO;
import com.example.DTO.entity.DepartmentEntity;
import com.example.DTO.entity.EmployeeEntity;
import com.example.DTO.mapper.EmployeeDetailsMapper;
import com.example.DTO.mapper.EmployeeMapper;
import com.example.DTO.repository.DepartmentRepository;
import com.example.DTO.repository.EmployeeRepository;
import com.example.DTO.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeDetailsMapper employeeDetailsMapper;


    @Override
    public EmployeeEntity createEmployeeService(EmployeeDTO employeeDTO){

        /// without using map-struct
        /*EmployeeEntity employee = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .email(employeeDTO.getEmail())
                .contect(employeeDTO.getContect())
                .department(employeeDTO.getDepartment())
                .build();
        return employeeRepository.save(employee);*/

        // 1️⃣ Check if department already exists
        DepartmentEntity department = departmentRepository.findByDepartmentName(
                employeeDTO.getDepartment().getDepartmentName()
        ).orElseThrow(() ->
                new RuntimeException("Department not found")
        );

        // 2️⃣ Map DTO → Employee (WITHOUT department)
        EmployeeEntity employee = employeeMapper.toEntity(employeeDTO);

        // 3️⃣ Attach managed department
        employee.setDepartment(department);

        // 4️⃣ Save
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAllUsers(){

        return employeeMapper.employeeDTOList(employeeRepository.GetAllUsersFromDb());
    }

    @Override
    public EmployeeDetailsDTO findUsersByNameContaining(String name){

      return employeeRepository.findByNameContaining(name).map(employeeEntity -> {
          return employeeDetailsMapper.toEmployeesDetailDTO(employeeEntity,employeeEntity.getDepartment());
      }).orElse(new EmployeeDetailsDTO());
    }


}
