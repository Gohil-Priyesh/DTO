package com.example.DTO.mapper;

import com.example.DTO.dto.OrderDTO;
import com.example.DTO.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "totalAmount" , target = "totalAmount")
    /// if I want to change the date formate then just add the dateFormat that's it
    @Mapping(source = "orderDateTime" , target = "orderDateTime",dateFormat = "yyy-MMM-dd")
    OrderEntity toEntity(OrderDTO orderDTO);

    @Mapping(source = "totalAmount" , target = "totalAmount")
    @Mapping(source = "orderDateTime" , target = "orderDateTime",dateFormat = "yyy-MMM-dd")
    OrderDTO toDTO(OrderEntity orderEntity);
}
