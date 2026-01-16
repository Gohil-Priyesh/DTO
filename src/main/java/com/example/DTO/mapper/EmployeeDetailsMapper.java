package com.example.DTO.mapper;

import com.example.DTO.dto.DepartmentDTO;
import com.example.DTO.dto.EmployeeDetailsDTO;
import com.example.DTO.entity.DepartmentEntity;
import com.example.DTO.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

///  this is for create dto which has data from multiple sources like in this case EmployeeEntity and the DepartmentEntity
/// which are having Many to One relations
@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {

    @Mappings({
            /// this can be commented
//            @Mapping(source = "employeeEntity.name", target = "name"),
//            @Mapping(source = "employeeEntity.email", target = "email"),
//            @Mapping(source = "employeeEntity.contact", target = "contact"),
            @Mapping(source = "departmentEntity.departmentName", target = "department")
    })
    EmployeeDetailsDTO toEmployeesDetailDTO(
            EmployeeEntity employeeEntity,
            DepartmentEntity departmentEntity
    );
}

