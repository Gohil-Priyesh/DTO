package com.example.DTO.mapper;

import com.example.DTO.dto.UserDTO;
import com.example.DTO.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/// mapping the dto and entity with different names
@Mapper(componentModel = "spring")
public interface UserMapper {

    /// for mapping dto to entity when the field name are different
    @Mapping(source = "email",target = "userEmail")
    @Mapping(source = "age",target = "userAge")
    @Mapping(source = "contact",target = "userContact")
    UserEntity toEntity (UserDTO userDTO);

    /// by using this mapping even though the fields names are different in  DTO from the Entity class we can still pass the data
    @Mapping(target = "email",source = "userEmail")
    @Mapping(target = "age",source = "userAge")
    @Mapping(target = "contact",source = "userContact")
    UserDTO toDTO (UserEntity userEntity);

    List<UserDTO> toDTOList(List<UserEntity> userList);
}
