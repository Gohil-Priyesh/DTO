package com.example.DTO.mapper;

import com.example.DTO.dto.EmployeeDTO;
import com.example.DTO.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/// this is for patch or put api if lets say i only update name and send other field as null then it won't make the current
/// row in database null only will update the name
///  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = DepartmentMapper.class /// this  is used if this DTO contains another DTO as a field
        /// to make the mapstruct know that this is a call and not a primitive datatype
)
public interface EmployeeMapper {

    /// CREATE: DTO → Entity
    @Mapping(target = "id", ignore = true)
    EmployeeEntity toEntity(EmployeeDTO employeeDTO);

    /// UPDATE: DTO → EXISTING Entity
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EmployeeDTO dto, @MappingTarget EmployeeEntity entity);

    /// READ: Entity → DTO
    EmployeeDTO toDTO(EmployeeEntity employeeEntity);

    /// READ: List mapping
    List<EmployeeDTO> employeeDTOList(List<EmployeeEntity> employeeEntityList);
}
