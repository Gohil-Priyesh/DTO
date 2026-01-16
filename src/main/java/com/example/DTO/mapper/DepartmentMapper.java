package com.example.DTO.mapper;

import com.example.DTO.dto.DepartmentDTO;
import com.example.DTO.entity.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO toDepartmentDto(DepartmentEntity department);
}
