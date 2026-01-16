package com.example.DTO.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDTO {

    private String userName;

    private String email;

    private Integer age;

    private Integer contact;
}
