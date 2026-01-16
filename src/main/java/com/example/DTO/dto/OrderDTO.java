package com.example.DTO.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Integer id;

    private Integer orderId;

    private String orderDateTime;

    private Integer orderQuantity;

    private String totalAmount; /// in the entity this is float,and I am converting this type with mapstruct

}
