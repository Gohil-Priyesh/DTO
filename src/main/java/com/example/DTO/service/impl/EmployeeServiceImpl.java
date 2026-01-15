package com.example.DTO.service.impl;

import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.entity.EmployeeEntity;
import com.example.DTO.mapper.EmployeeMapper;
import com.example.DTO.repository.EmployeeRepository;
import com.example.DTO.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public void createEmployeeServiceWithoutDTO(EmployeeEntity employeeEntity){
         employeeRepository.save(employeeEntity);
    }
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

        ///  using map-struct
       return employeeRepository.save(employeeMapper.toEntity(employeeDTO));
    }

    @Override
    public List<EmployeeEntity> getAllUsers(){
        return  employeeRepository.GetAllUsersFromDb();
    }

//    @Override
//    public List<EmployeeDTO>findUsersByNameContaining(String name){
//      List<EmployeeEntity> employeesList = employeeRepository.findByNameContaining(name);
//      employeesList.
//        return
//    }


}
